package net.deechael.dodo.api;

import com.google.gson.JsonObject;
import net.deechael.dodo.content.Content;
import net.deechael.dodo.types.ChannelType;
import net.deechael.dodo.types.MessageType;

public interface RawMessage {

    MessageType getType();

    ChannelType getChannelType();

    String getTargetId();

    String getAuthorId();

    Content getContent();

    String getId();

    long getTimestamp();

    String getNonce();

    JsonObject getExtra();

}
