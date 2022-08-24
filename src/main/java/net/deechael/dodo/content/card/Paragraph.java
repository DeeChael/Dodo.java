package net.deechael.dodo.content.card;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Element {

    @Getter
    private final int cols;
    private final List<Text> fields = new ArrayList<>();

    public Paragraph(int cols) {
        if (cols > 6 || cols < 2)
            throw new RuntimeException("The cols should be in [2, 6]");
        this.cols = cols;
    }

    public void append(Text text) {
        this.fields.add(text);
    }

    @Override
    public JsonObject get() {
        JsonArray textArray = new JsonArray();
        for (Text text : fields) {
            textArray.add(text.get());
        }
        JsonObject object = new JsonObject();
        object.addProperty("type", "paragraph");
        object.addProperty("cols", cols);
        object.add("fields", textArray);
        return object;
    }

}
