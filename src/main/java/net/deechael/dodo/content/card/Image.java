package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class Image implements Element, Component {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String src;

    public Image(String src) {
        this.src = src;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("type", "image");
        object.addProperty("src", src);
        return object;
    }

}
