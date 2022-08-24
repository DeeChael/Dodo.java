package net.deechael.dodo.content.card;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class ButtonGroup implements Component {

    private final List<Button> elements = new ArrayList<>();

    public void append(Button button) {
        this.elements.add(button);
    }

    @Override
    public JsonObject get() {
        JsonArray elementArray = new JsonArray();
        for (Element element : elements) {
            elementArray.add(element.get());
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "button-group");
        jsonObject.add("elements", elementArray);
        return jsonObject;
    }

}
