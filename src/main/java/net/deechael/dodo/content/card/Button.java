package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import net.deechael.dodo.types.card.ButtonActionType;
import net.deechael.dodo.types.card.ButtonColorType;

public class Button implements Element {

    @Getter
    @Setter
    private String interactCustomId = null;
    @Getter
    @Setter
    private ButtonActionType action;
    @Getter
    @Setter
    private String value;
    @Getter
    @Setter
    private ButtonColorType color;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
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
