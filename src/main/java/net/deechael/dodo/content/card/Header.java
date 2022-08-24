package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class Header implements Component {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private Text text;

    public Header(String plain) {
        this(new Text(plain));
    }

    public Header(Text text) {
        this.text = text;
    }

    public Header setText(String plain) {
        this.text = new Text(plain);
        return this;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("type", "header");
        object.add("text", text.get());
        return object;
    }

}
