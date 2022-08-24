package net.deechael.dodo.types.card;

import lombok.Getter;

public enum TextType {

    PLAIN("plain-text"),
    MARKDOWN("dodo-md");

    @Getter
    private final String code;

    TextType(String code) {
        this.code = code;
    }

}
