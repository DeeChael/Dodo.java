package net.deechael.dodo.content.card;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class ImageGroup implements Component {

    private final List<Image> elements = new ArrayList<>();

    public ImageGroup append(Image image) {
        this.elements.add(image);
        return this;
    }

    @Override
    public JsonObject get() {
        JsonArray elementArray = new JsonArray();
        for (Element element : elements) {
            elementArray.add(element.get());
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "image-group");
        jsonObject.add("elements", elementArray);
        return jsonObject;
    }

}
