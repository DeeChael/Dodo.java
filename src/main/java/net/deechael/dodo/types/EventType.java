package net.deechael.dodo.types;

import lombok.Getter;

public enum EventType {

    // Text Channel Events
    CHANNEL_MESSAGE(2001),
    MESSAGE_REACTION(3001),
    CARD_MESSAGE_BUTTON_CLICK(3002),
    CARD_MESSAGE_FORM_SUBMIT(3003),
    CARD_MESSAGE_LIST_SUBMIT(3004),
    // Member Events
    MEMBER_JOIN(4001),
    MEMBER_LEAVE(4002),
    // Personal Message Events
    PERSONAL_MESSAGE(1001),
    // Unknown
    UNKNOWN(-1);

    @Getter
    private final int id;

    EventType(int id) {
        this.id = id;
    }

}
