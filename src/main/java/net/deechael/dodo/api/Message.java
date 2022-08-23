package net.deechael.dodo.api;

import net.deechael.dodo.content.Content;

public interface Message extends RawMessage {

    Channel getChannel();

    User getAuthor();

    default void addReaction(GuildEmoji emoji) {
        this.addReaction(emoji.getId());
    }

    void addReaction(String emoji);

    default void deleteReaction(GuildEmoji emoji) {
        this.deleteReaction(emoji.getId());
    }

    void deleteReaction(String emoji);

    default void deleteReaction(GuildEmoji emoji, User whose) {
        this.deleteReaction(emoji.getId(), whose.getId());
    }

    default void deleteReaction(String emoji, User whose) {
        this.deleteReaction(emoji, whose.getId());
    }

    default void deleteReaction(GuildEmoji emoji, String whose) {
        this.deleteReaction(emoji.getId(), whose);
    }

    void deleteReaction(String emoji, String whose);

    void reply(Content content, boolean quote);

    default void reply(Content content) {
        this.reply(content, true);
    }

}
