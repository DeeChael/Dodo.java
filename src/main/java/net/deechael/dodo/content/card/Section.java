package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import net.deechael.dodo.types.card.SectionAlignType;

public class Section implements Component {

    @Getter
    private final Element text;
    @Getter
    @Setter
    private SectionAlignType align = null;
    private Element accessory = null;

    public Section(String plain) {
        this(new Text(plain));
    }

    public Section(Text text) {
        this.text = text;
    }

    public Section(Paragraph paragraph) {
        this.text = paragraph;
    }

    public void setAccessory(Image accessory) {
        this.accessory = accessory;
    }

    public void setAccessory(Button accessory) {
        this.accessory = accessory;
    }

    @Override
    public JsonObject get() {
        JsonObject object = new JsonObject();
        object.addProperty("type", "section");
        object.add("text", text.get());
        if (align != null) {
            object.addProperty("align", align.getCode());
        }
        if (accessory != null) {
            object.add("accessory", accessory.get());
        }
        return object;
    }

}
