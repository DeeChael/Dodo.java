package net.deechael.dodo.impl;

import com.google.gson.JsonObject;
import lombok.Getter;
import net.deechael.dodo.API;
import net.deechael.dodo.api.Channel;
import net.deechael.dodo.gate.Gateway;
import net.deechael.dodo.network.Route;
import net.deechael.dodo.types.ChannelType;

public class ChannelImpl implements Channel {

    protected final Gateway gateway;

    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private ChannelType type;
    @Getter
    private String islandId;
    private boolean isDefault;
    @Getter
    private String groupId;
    @Getter
    private String groupName;

    public ChannelImpl(Gateway gateway, JsonObject info) {
        this.gateway = gateway;
        this.id = info.get("channelId").getAsString();
        this.name = info.get("name").getAsString();
        this.type = ChannelType.of(info.get("channelType").getAsInt());
        this.islandId = info.get("islandId").getAsString();
        this.isDefault = info.get("defaultFlag").getAsInt() == 1;
        this.groupId = info.get("groupId").getAsString();
        this.groupName = info.get("groupName").getAsString();
    }

    @Override
    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public void setName(String name) {
        Route route = API.V1.Channel.edit()
                .param("islandId", getIslandId())
                .param("channelId", getId())
                .param("channelName", name);
        gateway.executeRequest(route);
    }

    @Override
    public void remove() {
        Route route = API.V1.Channel.remove()
                .param("islandId", getIslandId())
                .param("channelId", getId());
        gateway.executeRequest(route);
    }

}
