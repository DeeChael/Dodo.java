package net.deechael.dodo.content.card;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.deechael.dodo.types.card.SectionAlignType;

public class Section implements Component {

    @Getter
    private Element text;
    @Getter
    @Setter
    @Accessors(fluent = true)
    private SectionAlignType align = null;
    @Getter
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

    public Section setText(String plain) {
        this.text = new Text(plain);
        return this;
    }

    public Section setText(Text text) {
        this.text = text;
        return this;
    }

    public Section setText(Paragraph text) {
        this.text = text;
        return this;
    }

    public Section setAccessory(Image accessory) {
        this.accessory = accessory;
        return this;
    }

    public Section setAccessory(Button accessory) {
        this.accessory = accessory;
        return this;
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
