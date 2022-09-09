package net.deechael.dodo.impl;

import com.google.gson.JsonObject;
import net.deechael.dodo.API;
import net.deechael.dodo.api.*;
import net.deechael.dodo.command.CommandManager;
import net.deechael.dodo.command.DodoCommand;
import net.deechael.dodo.content.Message;
import net.deechael.dodo.content.TextMessage;
import net.deechael.dodo.event.EventManager;
import net.deechael.dodo.event.Listener;
import net.deechael.dodo.gate.Gateway;
import net.deechael.dodo.network.Requester;
import net.deechael.dodo.network.Route;
import net.deechael.dodo.network.WebSocketReceiver;
import net.deechael.dodo.types.ChannelType;
import net.deechael.dodo.types.MessageType;
import okhttp3.OkHttpClient;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ClientImpl implements Client {

    private final Gateway gateway;

    private final EventManager eventManager;
    private final CommandManager commandManager;

    private boolean started = false;

    public ClientImpl(int clientId, String token) {
        OkHttpClient client = new OkHttpClient.Builder().pingInterval(30, TimeUnit.SECONDS).build();
        this.gateway = new Gateway(new Requester(client, clientId, token),
                new WebSocketReceiver(client, clientId, token, this::pkgReceive));
        this.eventManager = new EventManager(this);
        this.commandManager = new CommandManager();
    }

    @Override
    public void start() {
        if (started)
            return;
        started = true;
        this.gateway.getReceiver().start();
    }

    @Override
    public boolean isStart() {
        return started && this.gateway.getReceiver().isStart();
    }

    @Override
    public void addEventListener(Listener listener) {
        this.eventManager.addListener(listener);
    }

    @Override
    public void unregisterEventListener(Listener listener) {
        this.eventManager.unregisterListener(listener);
    }

    @Override
    public void registerCommand(DodoCommand command) {
        this.commandManager.register(command);
    }

    @Override
    public Island fetchIsland(String islandId) {
        Route route = API.V1.Island.info()
                .param("islandId", islandId);
        JsonObject info = gateway.executeRequest(route).getAsJsonObject();
        return new IslandImpl(gateway, info);
    }

    @Override
    public Channel fetchChannel(String islandId, String channelId) {
        Route route = API.V1.Channel.info()
                .param("islandId", islandId)
                .param("channelId", channelId);
        JsonObject info = gateway.executeRequest(route).getAsJsonObject();
        if (info.get("channelType").getAsInt() == 1) {
            return new TextChannelImpl(gateway, info);
        } else if (info.get("channelType").getAsInt() == 2) {
            return new VoiceChannelImpl(gateway, info);
        } else {
            return new ChannelImpl(gateway, info);
        }
    }

    @Override
    public Member fetchMember(String islandId, String dodoId) {
        Route route = API.V1.Member.info()
                .param("islandId", islandId)
                .param("dodoId", dodoId);
        JsonObject info = gateway.executeRequest(route).getAsJsonObject();
        info.addProperty("islandId", islandId);
        return new MemberImpl(gateway, info);
    }

    @Override
    public String uploadImage(File imageFile) {
        Route route = API.V1.Resource.pictureUpload().param("file", imageFile);
        return this.gateway.executeRequest(route).getAsJsonObject().get("url").getAsString();
    }

    @Override
    public String updateMessage(String messageId, Message content) {
        Route route = API.V1.Channel.messageEdit()
                .param("messageId", messageId)
                .param("messageType", content.getType().getCode())
                .param("messageBody", content.get());
        return this.gateway.executeRequest(route).getAsJsonObject().get("messageId").getAsString();
    }

    private void pkgReceive(JsonObject pkg) {
        JsonObject data = pkg.getAsJsonObject("data");
        if (Objects.equals(data.get("eventType").getAsString(), "2001")) {
            if (data.getAsJsonObject("eventBody").get("messageType").getAsInt() == 1) {
                try {
                    long timestamp = data.get("timestamp").getAsLong();
                    JsonObject eventJson = data.getAsJsonObject("eventBody");
                    String islandId = string(eventJson, "islandId");
                    String channelId = string(eventJson, "channelId");
                    String dodoId = string(eventJson, "dodoId");
                    String messageId = string(eventJson, "messageId");
                    Member member = this.fetchMember(islandId, dodoId);

                    MessageType type = MessageType.of(eventJson.get("messageType").getAsInt());
                    Message body = Message.parse(type, eventJson.getAsJsonObject("messageBody"));

                    MessageContext context = new MessageContextImpl(timestamp, messageId, body,
                            member, this.fetchChannel(islandId, channelId), this.fetchIsland(islandId));
                    if (body != null) {
                        commandManager.execute(context, ((TextMessage) body).getContent());
                    }
                } catch (Exception ignored) {
                    // To prevent the event won't be fired
                }
            }
        }
        this.eventManager.callEvent(data);
    }

    private String string(JsonObject object, String key) {
        return object.get(key).getAsString();
    }

}
