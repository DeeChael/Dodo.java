package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;

public class Header implements Component {

    @Getter
    private final Text text;

    public Header(String plain) {
        this(new Text(plain));
    }

    public Header(Text text) {
        this.text = text;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("type", "header");
        object.add("text", text.get());
        return object;
    }

}
