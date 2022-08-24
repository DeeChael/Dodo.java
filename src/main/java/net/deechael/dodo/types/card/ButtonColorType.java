package net.deechael.dodo.types.card;

import lombok.Getter;

public enum ButtonColorType {

    GREY("grey"),
    RED("red"),
    ORANGE("orange"),
    GREEN("green"),
    BLUE("blue"),
    PURPLE("purple"),
    DEFAULT("default");

    @Getter
    private final String code;

    ButtonColorType(String code) {
        this.code = code;
    }

}
