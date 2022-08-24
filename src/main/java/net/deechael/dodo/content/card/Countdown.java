package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import net.deechael.dodo.types.card.CountdownStyleType;

public class Countdown implements Component {

    @Getter
    @Setter
    private String title = null;
    @Getter
    @Setter
    private CountdownStyleType style;
    @Getter
    @Setter
    private long endTime;

    public Countdown(CountdownStyleType style, long endTime) {
        this.style = style;
        this.endTime = endTime;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("type", "countdown");
        if (title != null) {
            object.addProperty("title", title);
        }
        object.addProperty("style", style.getCode());
        object.addProperty("endTime", endTime);
        return object;
    }

}
