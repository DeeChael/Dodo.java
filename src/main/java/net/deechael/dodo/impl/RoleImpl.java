package net.deechael.dodo.impl;

import com.google.gson.JsonObject;
import lombok.Getter;
import net.deechael.dodo.API;
import net.deechael.dodo.api.Role;
import net.deechael.dodo.gate.Gateway;
import net.deechael.dodo.network.Route;

public class RoleImpl implements Role {

    private final Gateway gateway;

    @Getter
    private String islandId;
    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private String color;
    @Getter
    private int position;
    @Getter
    private String permission;

    public RoleImpl(Gateway gateway, JsonObject info) {
        this.gateway = gateway;
        this.islandId = info.get("islandId").getAsString();
        this.id = info.get("roleId").getAsString();
        this.name = info.get("roleName").getAsString();
        this.color = info.get("roleColor").getAsString();
        this.position = info.get("position").getAsInt();
        this.permission = info.get("permission").getAsString();
    }

    @Override
    public void setName(String name) {
        Route route = API.V1.Role.edit()
                .param("islandId", getIslandId())
                .param("roleId", getId())
                .param("roleName", name);
        gateway.executeRequest(route);
    }

    @Override
    public void setColor(String color) {
        Route route = API.V1.Role.edit()
                .param("islandId", getIslandId())
                .param("roleId", getId())
                .param("roleColor", color);
        gateway.executeRequest(route);
    }

    @Override
    public void setPosition(int position) {
        Route route = API.V1.Role.edit()
                .param("islandId", getIslandId())
                .param("roleId", getId())
                .param("position", position);
        gateway.executeRequest(route);
    }

    @Override
    public void setPermission(String permission) {
        Route route = API.V1.Role.edit()
                .param("islandId", getIslandId())
                .param("roleId", getId())
                .param("permission", permission);
        gateway.executeRequest(route);
    }

    @Override
    public void remove() {
        Route route = API.V1.Role.remove()
                .param("islandId", getIslandId())
                .param("roleId", getId());
        gateway.executeRequest(route);
    }

}
