package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.deechael.dodo.types.card.TextType;

public class Text implements Element {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private TextType type = TextType.PLAIN;

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String content;

    public Text(String content) {
        this.content = content;
    }

    public Text(String content, TextType type) {
        this.content = content;
        this.type = type;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("type", type.getCode());
        object.addProperty("content", content);
        return object;
    }

}
