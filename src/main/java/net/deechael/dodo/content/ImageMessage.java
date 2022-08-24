package net.deechael.dodo.content;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.deechael.dodo.types.MessageType;

public class ImageMessage implements Message {

    private final String url;
    private final int width;
    private final int height;

    private boolean original = false;

    public ImageMessage(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    @Override
    public JsonElement get() {
        JsonObject object = new JsonObject();
        object.addProperty("url", url);
        object.addProperty("width", width);
        object.addProperty("height", height);
        object.addProperty("isOriginal", original ? 1 : 0);
        return object;
    }

    @Override
    public MessageType getType() {
        return MessageType.IMAGE;
    }

}
