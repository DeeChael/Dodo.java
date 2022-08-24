package net.deechael.dodo.impl;

import lombok.Getter;
import net.deechael.dodo.api.*;
import net.deechael.dodo.content.Message;

public class MessageContextImpl implements MessageContext {

    @Getter
    private long timestamp;
    @Getter
    private String messageId;
    @Getter
    private Message content;
    @Getter
    private Member author;
    @Getter
    private Channel channel;
    @Getter
    private Island island;


    public MessageContextImpl(long timestamp,
                              String messageId,
                              Message content,
                              Member author,
                              Channel channel,
                              Island island
                              ) {
        this.timestamp = timestamp;
        this.messageId = messageId;
        this.content = content;
        this.author = author;
        this.channel = channel;
        this.island = island;
    }

    @Override
    public void reply(Message content) {
        ((TextChannel) content).send(content, this.messageId);
    }

    @Override
    public void addReaction(String emoji) {
        ((TextChannel) content).addReaction(this.messageId, emoji);
    }

    @Override
    public void removeReaction(String emoji) {
        ((TextChannel) content).removeReaction(this.messageId, emoji);
    }

    @Override
    public void removeReaction(String emoji, String dodoId) {
        ((TextChannel) content).removeReaction(this.messageId, emoji, dodoId);
    }

}
