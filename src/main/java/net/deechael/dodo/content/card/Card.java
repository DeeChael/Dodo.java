package net.deechael.dodo.content.card;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import net.deechael.dodo.types.card.CardThemeType;

import java.util.ArrayList;
import java.util.List;

public class Card {

    @Getter
    @Setter
    private CardThemeType theme = CardThemeType.DEFAULT;

    @Getter
    @Setter
    private String title = "";

    private final List<Component> components = new ArrayList<>();

    public Card() {
    }

    public void append(Component component) {
        this.components.add(component);
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
