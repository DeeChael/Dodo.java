package net.deechael.dodo.content.card;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Remark implements Component {

    private final List<Element> elements = new ArrayList<>();

    public void append(Text text) {
        this.elements.add(text);
    }

    public void append(Image image) {
        this.elements.add(image);
    }

    @Override
    public JsonObject get() {
        JsonArray elementArray = new JsonArray();
        for (Element element : elements) {
            elementArray.add(element.get());
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "remark");
        jsonObject.add("elements", elementArray);
        return jsonObject;
    }
}
