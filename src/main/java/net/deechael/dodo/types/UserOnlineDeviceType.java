package net.deechael.dodo.types;

import lombok.Getter;

public enum UserOnlineDeviceType {

    NONE(0),
    PC(1),
    PHONE(2);

    @Getter
    private final int code;

    UserOnlineDeviceType(int code) {
        this.code = code;
    }

}
