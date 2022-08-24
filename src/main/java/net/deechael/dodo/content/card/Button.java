package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.deechael.dodo.types.card.ButtonActionType;
import net.deechael.dodo.types.card.ButtonColorType;

public class Button implements Element {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String interactCustomId = null;
    @Getter
    @Setter
    @Accessors(fluent = true)
    private ButtonActionType action;
    @Getter
    @Setter
    @Accessors(fluent = true)
    private String value;
    @Getter
    @Setter
    @Accessors(fluent = true)
    private ButtonColorType color;
    @Getter
    @Setter
    @Accessors(fluent = true)
    private String name;
    @Getter
    @Setter
    @Accessors(fluent = true)
    private Form form = null;

    public Button(ButtonActionType action, String value, ButtonColorType color, String name) {
        this.action = action;
        this.value = value;
        this.color = color;
        this.name = name;
    }

    @Override
    public JsonObject get() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "button");
        if (interactCustomId != null) {
            jsonObject.addProperty("interactCustomId", interactCustomId);
        }
        // Click
        JsonObject click = new JsonObject();
        click.addProperty("value", value);
        click.addProperty("action", action.getCode());
        jsonObject.add("click", click);

        jsonObject.addProperty("color", color.getCode());
        jsonObject.addProperty("name", name);
        if (this.form != null) {
            jsonObject.add("form", form.get());
        }
        return jsonObject;
    }
}
