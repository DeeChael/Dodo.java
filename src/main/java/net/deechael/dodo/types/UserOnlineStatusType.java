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

    public static UserOnlineStatusType of(int code) {
        if (code == 1)
            return ONLINE;
        if (code == 2)
            return WORKING;
        if (code == 3)
            return LEAVE;
        return OFFLINE;
    }

}
