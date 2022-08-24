package net.deechael.dodo.event.channel;

import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;

public class MessageReactionEvent extends Event {

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
    private final String targetId;
    @Getter
    private final String emojiId;
    @Getter
    private final ReactionType reactionType;

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

    public enum ReactionType {

        ADD, REMOVE

    }

}
