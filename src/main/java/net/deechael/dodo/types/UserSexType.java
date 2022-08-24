package net.deechael.dodo.types;

import lombok.Getter;

public enum UserSexType {

    SECRET(-1),
    FEMALE(0),
    MALE(1);

    @Getter
    private final int code;

    UserSexType(int code) {
        this.code = code;
    }

}
