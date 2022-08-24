package net.deechael.dodo.content;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.deechael.dodo.content.card.Card;
import net.deechael.dodo.types.MessageType;

public class CardMessage implements Message {

    private final Card card;
    private String content = null;

    public CardMessage(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public JsonElement get() {
        JsonObject object = new JsonObject();
        if (content != null) {
            object.addProperty("content", content);
        }
        object.add("card", this.card.get());
        return null;
    }

    @Override
    public MessageType getType() {
        return MessageType.CARD;
    }

}
