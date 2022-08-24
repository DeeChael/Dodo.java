package net.deechael.dodo.event.channel;

import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;

public class CardMessageButtonClickEvent extends Event {

    @Getter
    private final String islandId;
    @Getter
    private final String channelId;
    @Getter
    private final String dodoId;
    @Getter
    private final String messageId;
    @Getter
    private final Member member;
    @Getter
    private final String interactCustomId;
    @Getter
    private final String value;

    public CardMessageButtonClickEvent(String id, long timestamp, String islandId, String channelId,
                                       String dodoId, String messageId, Member member, String interactCustomId,
                                       String value) {
        super(id, EventType.CARD_MESSAGE_BUTTON_CLICK, timestamp);
        this.islandId = islandId;
        this.channelId = channelId;
        this.dodoId = dodoId;
        this.messageId = messageId;
        this.member = member;
        this.interactCustomId = interactCustomId;
        this.value = value;
    }

}
