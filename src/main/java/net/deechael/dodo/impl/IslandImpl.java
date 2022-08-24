package net.deechael.dodo.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;
import net.deechael.dodo.API;
import net.deechael.dodo.api.Channel;
import net.deechael.dodo.api.Island;
import net.deechael.dodo.api.Role;
import net.deechael.dodo.gate.Gateway;
import net.deechael.dodo.network.Route;
import net.deechael.dodo.types.ChannelType;

import java.util.ArrayList;
import java.util.List;

public class IslandImpl implements Island {

    private final Gateway gateway;

    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private String coverUrl;
    @Getter
    private int memberCount;
    @Getter
    private int onlineMemberCount;
    @Getter
    private String description;
    @Getter
    private String defaultChannelId;
    @Getter
    private String systemChannelId;

    public IslandImpl(Gateway gateway, JsonObject info) {
        this.gateway = gateway;
        this.id = info.get("islandId").getAsString();
        this.name = info.get("islandName").getAsString();
        this.coverUrl = info.get("coverUrl").getAsString();
        this.memberCount = info.get("memberCount").getAsInt();
        this.onlineMemberCount = info.get("onlineMemberCount").getAsInt();
        this.description = info.get("description").getAsString();
        this.defaultChannelId = info.get("defaultChannelId").getAsString();
        this.systemChannelId = info.get("systemChannelId").getAsString();
    }

    @Override
    public List<String> getMuteList() {
        List<String> muted = new ArrayList<>();
        long maxId = 0;
        int times = this.memberCount % 100 == 0 ? this.memberCount / 100 : this.memberCount / 100 + 1;
        for (int i = 0; i < times; i++) {
            JsonObject data = gateway.executeRequest(API.V1.Island.muteList()
                    .param("islandId", getId())
                    .param("pageSize", 100)
                    .param("maxId", maxId)).getAsJsonObject();
            maxId = data.get("maxId").getAsLong();
            for (JsonElement element : data.getAsJsonArray("list")) {
                muted.add(element.getAsJsonObject().get("dodoId").getAsString());
            }
        }
        return muted;
    }

    @Override
    public List<String> getBanList() {
        List<String> banned = new ArrayList<>();
        long maxId = 0;
        int times = this.memberCount % 100 == 0 ? this.memberCount / 100 : this.memberCount / 100 + 1;
        for (int i = 0; i < times; i++) {
            JsonObject data = gateway.executeRequest(API.V1.Island.banList()
                    .param("islandId", getId())
                    .param("pageSize", 100)
                    .param("maxId", maxId)).getAsJsonObject();
            maxId = data.get("maxId").getAsLong();
            for (JsonElement element : data.getAsJsonArray("list")) {
                banned.add(element.getAsJsonObject().get("dodoId").getAsString());
            }
        }
        return banned;
    }

    @Override
    public List<Channel> getChannels() {
        List<Channel> channels = new ArrayList<>();
        Route route = API.V1.Channel.list()
                .param("islandId", getId());
        for (JsonElement element : gateway.executeRequest(route).getAsJsonArray()) {
            JsonObject object = element.getAsJsonObject();
            object.addProperty("islandId", getId());
            channels.add(new ChannelImpl(gateway, object));
        }
        return channels;
    }

    @Override
    public List<Role> getRoles() {
        List<Role> roles = new ArrayList<>();
        Route route = API.V1.Role.list()
                .param("islandId", getId());
        for (JsonElement element : gateway.executeRequest(route).getAsJsonArray()) {
            JsonObject object = element.getAsJsonObject();
            object.addProperty("islandId", getId());
            roles.add(new RoleImpl(gateway, object));
        }
        return roles;
    }

    @Override
    public String createRole(String name) {
        Route route = API.V1.Role.add()
                .param("islandId", getId())
                .param("name", name);
        return gateway.executeRequest(route).getAsJsonObject().get("roleId").getAsString();
    }

    @Override
    public String createChannel(String name, ChannelType type) {
        Route route = API.V1.Channel.add()
                .param("islandId", getId())
                .param("channelName", name)
                .param("channelType", type.getCode());
        return gateway.executeRequest(route).getAsJsonObject().get("channelId").getAsString();
    }

}
