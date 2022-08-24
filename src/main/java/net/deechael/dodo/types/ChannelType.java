package net.deechael.dodo.types;

import lombok.Getter;

public enum ChannelType {

    TEXT(1),
    VOICE(2),
    POST(4),
    LINK(5),
    INFO(6),
    UNKNOWN(-1);

    @Getter
    private final int code;

    ChannelType(int code) {
        this.code = code;
    }

    public static ChannelType of(int code) {
        if (code == 1)
            return TEXT;
        if (code == 2)
            return VOICE;
        if (code == 4)
            return POST;
        if (code == 5)
            return LINK;
        if (code == 6)
            return INFO;
        return UNKNOWN;
    }

}
