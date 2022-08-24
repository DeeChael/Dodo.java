package net.deechael.dodo.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;
import net.deechael.dodo.API;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.api.Role;
import net.deechael.dodo.content.Message;
import net.deechael.dodo.gate.Gateway;
import net.deechael.dodo.network.Route;
import net.deechael.dodo.types.UserOnlineDeviceType;
import net.deechael.dodo.types.UserOnlineStatusType;
import net.deechael.dodo.types.UserSexType;

import java.util.ArrayList;
import java.util.List;

public class MemberImpl implements Member {

    private final Gateway gateway;

    @Getter
    private final String id;
    @Getter
    private final String islandId;
    @Getter
    private final String nickname;
    @Getter
    private final String personalNickname;
    @Getter
    private final String avatarUrl;
    @Getter
    private final String joinTime;
    @Getter
    private final UserSexType sex;
    @Getter
    private final int level;
    @Getter
    private final boolean bot;
    @Getter
    private final UserOnlineDeviceType onlineDevice;
    @Getter
    private final UserOnlineStatusType onlineStatus;

    public MemberImpl(Gateway gateway, JsonObject info) {
        this.gateway = gateway;
        this.id = info.get("dodoId").getAsString();
        this.islandId = info.get("islandId").getAsString();
        this.nickname = info.get("nickName").getAsString();
        this.personalNickname = info.get("personalNickName").getAsString();
        this.avatarUrl = info.get("avatarUrl").getAsString();
        this.joinTime = info.get("joinTime").getAsString();
        this.sex = UserSexType.of(info.get("sex").getAsInt());
        this.level = info.get("level").getAsInt();
        this.bot = info.get("isBot").getAsInt() == 1;
        this.onlineDevice = UserOnlineDeviceType.of(info.get("onlineDevice").getAsInt());
        this.onlineStatus = UserOnlineStatusType.of(info.get("onlineStatus").getAsInt());
    }

    @Override
    public List<Role> getRoles() {
        Route route = API.V1.Member.roleList()
                .param("islandId", getIslandId())
                .param("dodoId", getId());
        List<Role> roles = new ArrayList<>();
        try {
            JsonArray array = gateway.executeRequest(route).getAsJsonArray();
            for (JsonElement element : array) {
                JsonObject object = element.getAsJsonObject();
                object.addProperty("islandId", getIslandId());
                roles.add(new RoleImpl(gateway, object));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void setNickname(String nickname) {

    }

    @Override
    public void mute(int seconds) {

    }

    @Override
    public void mute(int seconds, String reason) {

    }

    @Override
    public void unmute() {

    }

    @Override
    public void ban() {

    }

    @Override
    public void ban(String reason) {

    }

    @Override
    public void banNotice(String channelId) {

    }

    @Override
    public void banNotice(String channelId, String reason) {

    }

    @Override
    public void unban() {

    }

    @Override
    public void send(Message content) {

    }

    @Override
    public void addRole(String roleId) {

    }

    @Override
    public void removeRole(String roleId) {

    }

}
