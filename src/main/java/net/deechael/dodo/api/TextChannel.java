package net.deechael.dodo.api;

import net.deechael.dodo.content.Message;

public interface TextChannel extends Channel {

    String send(Message content);

    String send(Message content, String repliedMessageId);

    String sendPrivate(Message content, String dodoId);

    void addReaction(String messageId, String emoji);

    void removeReaction(String messageId, String emoji);

    void removeReaction(String messageId, String emoji, String dodoId);

}
