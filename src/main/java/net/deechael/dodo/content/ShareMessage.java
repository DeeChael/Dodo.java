package net.deechael.dodo.content;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.deechael.dodo.types.MessageType;

public class ShareMessage implements Message {

    private final String jumpUrl;

    public ShareMessage(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("jumpUrl", this.jumpUrl);
        return object;
    }

    @Override
    public MessageType getType() {
        return MessageType.SHARE;
    }

}
