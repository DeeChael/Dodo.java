package net.deechael.dodo.content.card;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.deechael.dodo.types.card.CardThemeType;

import java.util.ArrayList;
import java.util.List;

public class Card {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private CardThemeType theme = CardThemeType.DEFAULT;

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String title = "";

    private final List<Component> components = new ArrayList<>();

    public Card() {
    }

    public Card append(Component component) {
        this.components.add(component);
        return this;
    }

    public JsonObject get() {
        JsonArray componentArray = new JsonArray();
        for (Component component : components) {
            componentArray.add(component.get());
        }
        JsonObject object = new JsonObject();
        object.addProperty("type", "card");
        object.add("components", componentArray);
        object.addProperty("theme", theme.getCode());
        object.addProperty("title", title);
        return object;
    }

}
