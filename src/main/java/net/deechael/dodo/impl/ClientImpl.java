package net.deechael.dodo.impl;

import com.google.gson.JsonObject;
import net.deechael.dodo.API;
import net.deechael.dodo.api.Channel;
import net.deechael.dodo.api.Client;
import net.deechael.dodo.api.Island;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.content.Message;
import net.deechael.dodo.event.EventManager;
import net.deechael.dodo.event.Listener;
import net.deechael.dodo.gate.Gateway;
import net.deechael.dodo.network.Requester;
import net.deechael.dodo.network.Route;
import net.deechael.dodo.network.WebSocketReceiver;
import okhttp3.OkHttpClient;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ClientImpl implements Client {

    private final int clientId;
    private final String token;

    private final OkHttpClient client;
    private final Gateway gateway;

    private final EventManager eventManager;

    private boolean started = false;

    public ClientImpl(int clientId, String token) {
        this.clientId = clientId;
        this.token = token;
        this.client = new OkHttpClient.Builder().pingInterval(30, TimeUnit.SECONDS).build();
        this.gateway = new Gateway(new Requester(this.client, this.clientId, this.token),
                new WebSocketReceiver(this.client, this.clientId, this.token, this::pkgReceive));
        this.eventManager = new EventManager(this);
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
        if (info.get("channelType").getAsInt() == 1)
            return new TextChannelImpl(gateway, info);
        return new ChannelImpl(gateway, info);
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
        if (data.get("eventType").getAsString() == "2001") {
            if (data.getAsJsonObject("eventBody").get("messageType").getAsInt() == 1) {
                try {
                    // TODO: command
                } catch (Exception ignored) {
                    // To prevent the event won't be fired
                }
            }
        }
        this.eventManager.callEvent(data);
    }

}
