package net.deechael.dodo.event.channel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.api.MessageContext;
import net.deechael.dodo.content.Message;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;
import net.deechael.dodo.types.MessageType;

public final class ChannelMessageEvent extends Event {

    @Getter
    private MessageContext context;
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
    private Reference reference;
    @Getter
    private MessageType messageType;
    @Getter
    private Message body;

    public ChannelMessageEvent(String id, long timestamp, MessageContext context, String islandId, String channelId,
                               String dodoId, String messageId, Member member, Reference reference,
                               MessageType messageType, Message body) {
        super(id, EventType.CHANNEL_MESSAGE, timestamp);
        this.context = context;
        this.islandId = islandId;
        this.channelId = channelId;
        this.dodoId = dodoId;
        this.messageId = messageId;
        this.member = member;
        this.reference = reference;
        this.messageType = messageType;
        this.body = body;
    }

    @AllArgsConstructor
    public static class Reference {

        @Getter
        private String messageId;
        @Getter
        private String dodoId;
        @Getter
        private String nickName;

    }


}
