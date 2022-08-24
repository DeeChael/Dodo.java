package net.deechael.dodo.types;

import lombok.Getter;

public enum PermissionType {

    // General
    MANAGE_CHANNEL_AND_GROUP(0, 1),
    EDIT_CHANNEL(1, 2),
    VIEW_CHANNEL(6, 40),
    MANAGE_PERMISSION_ROLE(7, 80),
    MANAGE_GUILD_EMOJI(8, 100),
    MENTION_ALL_AND_ROLE(9, 200),
    SEARCH_CONTENT(20, 100000),
    // Member Management
    MANAGE_MEMBER(2, 4),
    EDIT_NICKNAME(4, 10),
    MANAGE_NICKNAME(5, 20),
    // Text Channel
    SEND_MESSAGE(10, 400),
    MANAGE_MESSAGE(11, 800),
    ADD_NEW_REACTION(12, 1000),
    // Post Channel
    SEND_POST(13, 2000),
    SEND_COMMENT(21, 200000),
    MANAGE_POST(14, 4000),
    DELETE_POST(15, 8000),
    // Voice
    CONNECT(16, 10000),
    SPEAK(17, 20000),
    MANAGE_VOICE(18, 40000),
    MOVE_MEMBER(19, 80000),
    // Advanced
    SUPER_ADMINISTRATOR(3, 8),
    ;

    @Getter
    private final int position;
    @Getter
    private final int hex;

    PermissionType(int position, int hex) {
        this.position = position;
        this.hex = hex;
    }

}
