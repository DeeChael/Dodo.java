package net.deechael.dodo.types.card;

import lombok.Getter;

public enum ButtonActionType {

    LINK_URL("link_url"),
    CALL_BACK("call_back"),
    COPY_CONTENT("copy_content"),
    FORM("form");

    @Getter
    private final String code;

    ButtonActionType(String code) {
        this.code = code;
    }

}
