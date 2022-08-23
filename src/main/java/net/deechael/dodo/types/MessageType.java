package net.deechael.dodo.types;

public enum MessageType {

    TEXT(1, "text"),
    IMG(2, "image"),
    VIDEO(3, "video"),
    CARD(6, "card"),
    UNKNOWN(-1, "unknown");

    private final int code;
    private final String name;

    MessageType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static MessageType of(int code) {
        switch (code) {
            case 1:
                return TEXT;
            case 2:
                return IMG;
            case 3:
                return VIDEO;
            case 6:
                return CARD;
        }
        return UNKNOWN;
    }

}
