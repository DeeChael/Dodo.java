package net.deechael.dodo.api;

import net.deechael.dodo.content.Message;

public interface MessageContext {

    long getTimestamp();

    String getMessageId();

    Message getContent();

    Member getAuthor();

    Channel getChannel();

    Island getIsland();

    void reply(Message content);

    void addReaction(String emoji);

    void removeReaction(String emoji);

    void removeReaction(String emoji, String dodoId);

}
