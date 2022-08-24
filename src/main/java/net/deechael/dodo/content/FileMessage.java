package net.deechael.dodo.content;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import net.deechael.dodo.types.MessageType;

@AllArgsConstructor
public class FileMessage implements Message {

    private final String url;
    private final String name;
    private final long size;

    @Override
    public JsonElement get() {
        JsonObject object = new JsonObject();
        object.addProperty("url", url);
        object.addProperty("name", name);
        object.addProperty("size", size);
        return object;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    @Override
    public MessageType getType() {
        return MessageType.FILE;
    }

}
