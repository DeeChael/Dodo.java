package net.deechael.dodo.content.card;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ListSelector implements Component {


    @Getter
    @Setter
    private String interactCustomId = null;
    @Getter
    @Setter
    private String placeholder = null;
    private final List<Element> elements = new ArrayList<>();
    @Getter
    @Setter
    private int min;
    @Getter
    @Setter
    private int max;

    public ListSelector(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void append(Element element) {
        this.elements.add(element);
    }

    @Override
    public JsonObject get() {
        JsonArray elementArray = new JsonArray();
        for (Element element : elements) {
            elementArray.add(element.get());
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "list-selector");
        if (interactCustomId != null) {
            jsonObject.addProperty("interactCustomId", interactCustomId);
        }
        if (placeholder != null) {
            jsonObject.addProperty("placeholder", placeholder);
        }
        jsonObject.add("elements", elementArray);
        jsonObject.addProperty("min", min);
        jsonObject.addProperty("max", max);
        return jsonObject;
    }

    public static class Element {

        @Getter
        @Setter
        private String name;
        @Getter
        @Setter
        private String desc = null;

        public Element(String name) {
            this.name = name;
        }

        public JsonObject get() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", "name");
            if (desc != null) {
                jsonObject.addProperty("desc", desc);
            }
            return jsonObject;
        }

    }

}
