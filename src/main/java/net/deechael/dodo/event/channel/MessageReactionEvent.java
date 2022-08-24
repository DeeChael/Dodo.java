package net.deechael.dodo.event.channel;

import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;

public class MessageReactionEvent extends Event {

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
    private String targetId;
    @Getter
    private String emojiId;
    @Getter
    private ReactionType reactionType;

    public MessageReactionEvent(String id, long timestamp, String islandId, String channelId,
                                String dodoId, String messageId, Member member, String targetId,
                                String emojiId, ReactionType type) {
        super(id, EventType.MESSAGE_REACTION, timestamp);
        this.islandId = islandId;
        this.channelId = channelId;
        this.dodoId = dodoId;
        this.messageId = messageId;
        this.member = member;
        this.targetId = targetId;
        this.emojiId = emojiId;
        this.reactionType = type;
    }

    public static enum ReactionType {

        ADD, REMOVE;

    }

}
