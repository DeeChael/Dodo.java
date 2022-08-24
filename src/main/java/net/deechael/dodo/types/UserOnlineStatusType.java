package net.deechael.dodo.types;

import lombok.Getter;

public enum UserOnlineStatusType {

    OFFLINE(0),
    ONLINE(1),
    WORKING(2),
    LEAVE(3);

    @Getter
    private final int code;

    UserOnlineStatusType(int code) {
        this.code = code;
    }

}
