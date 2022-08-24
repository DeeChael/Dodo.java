package net.deechael.dodo.types.card;

import lombok.Getter;

public enum SectionAlignType {

    LEFT("left"),
    RIGHT("right");

    @Getter
    private final String code;

    SectionAlignType(String code) {
        this.code = code;
    }

}
