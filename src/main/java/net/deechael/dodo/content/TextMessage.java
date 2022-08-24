package net.deechael.dodo.content;

import com.google.gson.JsonObject;
import net.deechael.dodo.types.MessageType;

public class TextMessage implements Message {

    private final String content;

    public TextMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("content", this.content);
        return object;
    }

    @Override
    public MessageType getType() {
        return MessageType.TEXT;
    }

}
