package net.deechael.dodo.types;

import lombok.Getter;

public enum ChannelType {

    TEXT(1),
    VOICE(2),
    POST(4),
    LINK(5),
    INFO(6);

    @Getter
    private final int code;

    ChannelType(int code) {
        this.code = code;
    }

}
