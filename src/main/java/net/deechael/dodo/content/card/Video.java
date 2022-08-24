package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

public class Video implements Component {

    @Getter
    @Setter
    private String title = null;
    @Getter
    @Setter
    private String cover;
    @Getter
    @Setter
    private String src;

    public Video(String cover, String src) {
        this.cover = cover;
        this.src = src;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("type", "video");
        if (title != null) {
            object.addProperty("title", title);
        }
        object.addProperty("cover", cover);
        object.addProperty("src", src);
        return object;
    }

}
