package net.deechael.dodo.content;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.deechael.dodo.types.MessageType;

public class VideoMessage implements Message {

    private final String url;
    private String coverUrl = null;
    private long duration = -1;
    private long size = -1;

    public VideoMessage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public long getDuration() {
        return duration;
    }

    public long getSize() {
        return size;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public JsonElement get() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("url", url);
        if (coverUrl != null) {
            jsonObject.addProperty("coverUrl", coverUrl);
        }
        if (duration != -1) {
            jsonObject.addProperty("duration", duration);
        }
        if (size != -1) {
            jsonObject.addProperty("size", size);
        }
        return jsonObject;
    }

    @Override
    public MessageType getType() {
        return MessageType.VIDEO;
    }
}
