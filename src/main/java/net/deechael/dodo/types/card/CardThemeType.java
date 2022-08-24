package net.deechael.dodo.types.card;

import lombok.Getter;

public enum CardThemeType {

    GREY("grey"),
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    INDIGO("indigo"),
    BLUE("blue"),
    PURPLE("purple"),
    BLACK("black"),
    DEFAULT("default");

    @Getter
    private final String code;

    CardThemeType(String code) {
        this.code = code;
    }

}
