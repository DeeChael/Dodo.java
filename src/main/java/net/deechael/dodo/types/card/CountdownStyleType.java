package net.deechael.dodo.types.card;

import lombok.Getter;

public enum CountdownStyleType {

    DAY("day"),
    HOUR("hour");

    @Getter
    private final String code;

    CountdownStyleType(String code) {
        this.code = code;
    }

}
