package net.deechael.dodo.api;

import net.deechael.dodo.content.Message;
import net.deechael.dodo.types.UserOnlineDeviceType;
import net.deechael.dodo.types.UserOnlineStatusType;
import net.deechael.dodo.types.UserSexType;

import java.util.List;

public interface Member {

    String getId();

    String getIslandId();

    String getNickname();

    String getPersonalNickname();

    String getAvatarUrl();

    String getJoinTime();

    UserSexType getSex();

    int getLevel();

    boolean isBot();

    UserOnlineDeviceType getOnlineDevice();

    UserOnlineStatusType getOnlineStatus();

    List<Role> getRoles();

    void setNickname(String nickname);

    void mute(int seconds);

    void mute(int seconds, String reason);

    void unmute();

    void ban();

    void ban(String reason);

    void banNotice(String channelId);

    void banNotice(String channelId, String reason);

    void unban();

    void send(Message content);

    void addRole(String roleId);

    void removeRole(String roleId);

}
