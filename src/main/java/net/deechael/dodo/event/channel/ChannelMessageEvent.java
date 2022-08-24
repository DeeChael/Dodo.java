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
    private final MessageContext context;
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
    private final Reference reference;
    @Getter
    private final MessageType messageType;
    @Getter
    private final Message body;

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
