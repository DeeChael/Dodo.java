package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;

public class Divider implements Component {

    @Override
    public JsonObject get() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "divider");
        return jsonObject;
    }

}
