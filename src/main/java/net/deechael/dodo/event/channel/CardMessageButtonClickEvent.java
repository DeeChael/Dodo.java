package net.deechael.dodo.event.channel;

import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;

public class CardMessageButtonClickEvent extends Event {

    @Getter
    private String islandId;
    @Getter
    private String channelId;
    @Getter
    private String dodoId;
    @Getter
    private String messageId;
    @Getter
    private Member member;
    @Getter
    private String interactCustomId;
    @Getter
    private String value;

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
