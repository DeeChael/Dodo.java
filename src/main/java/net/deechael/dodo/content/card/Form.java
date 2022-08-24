package net.deechael.dodo.content.card;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

public class Form {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String title;

    private final List<Element> elements = new ArrayList<>();

    public Form(String title) {
        this.title = title;
    }

    public Form append(Element element) {
        this.elements.add(element);
        return this;
    }

    public JsonObject get() {
        JsonArray elementArray = new JsonArray();
        for (Element element : elements) {
            elementArray.add(element.get());
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", title);
        jsonObject.add("elements", elementArray);
        return jsonObject;
    }

    public static class Input implements Element {

        @Getter
        @Setter
        @Accessors(fluent = true)
        private String key;
        @Getter
        @Setter
        @Accessors(fluent = true)
        private String title;
        @Getter
        @Setter
        @Accessors(fluent = true)
        private int rows;
        @Getter
        @Setter
        @Accessors(fluent = true)
        private String placeholder = null;
        @Getter
        @Setter
        @Accessors(fluent = true)
        private int minChar;
        @Getter
        @Setter
        @Accessors(fluent = true)
        private int maxChar;

        public Input(String key, String title, int rows, int minChar, int maxChar) {
            this.key = key;
            this.title = title;
            this.rows = rows;
            this.minChar = minChar;
            this.maxChar = maxChar;
        }

        @Override
        public JsonObject get() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", "input");
            jsonObject.addProperty("key", key);
            jsonObject.addProperty("title", title);
            jsonObject.addProperty("rows", rows);
            if (this.placeholder != null) {
                jsonObject.addProperty("placeholder", placeholder);
            }
            jsonObject.addProperty("minChar", minChar);
            jsonObject.addProperty("maxChar", maxChar);
            return jsonObject;
        }

    }

    public interface Element {

        JsonObject get();

    }

}
