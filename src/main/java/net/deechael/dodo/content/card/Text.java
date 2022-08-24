package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import net.deechael.dodo.types.card.TextType;

public class Text implements Element {

    @Getter
    @Setter
    private TextType type = TextType.PLAIN;

    @Getter
    @Setter
    private String content;

    public Text(String content) {
        this.content = content;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("type", type.getCode());
        object.addProperty("content", content);
        return object;
    }

}
