package net.deechael.dodo.event.channel;

import com.google.gson.*;
import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CardMessageFormSubmitEvent extends Event {

    @Getter
    private String islandId;
    @Getter
    private String channelId;
    @Getter
    private String dodoId;
    @Getter
    private String messageId;
    @Getter
    private Member member;
    @Getter
    private String interactCustomId;
    private final Map<String, Object> formData = new HashMap<>();

    public CardMessageFormSubmitEvent(String id, long timestamp, String islandId, String channelId,
                                      String dodoId, String messageId, Member member, String interactCustomId,
                                      JsonArray array) {
        super(id, EventType.CARD_MESSAGE_FORM_SUBMIT, timestamp);
        this.islandId = islandId;
        this.channelId = channelId;
        this.dodoId = dodoId;
        this.messageId = messageId;
        this.member = member;
        this.interactCustomId = interactCustomId;
        Gson gson = new Gson();
        for (JsonElement element : array) {
            JsonObject object = element.getAsJsonObject();
            String key = object.get("key").getAsString();
            JsonElement value = object.get("value");
            if (value.isJsonPrimitive()) {
                JsonPrimitive primitive = value.getAsJsonPrimitive();
                if (primitive.isString()) {
                    formData.put(key, primitive.getAsString());
                } else if (primitive.isNumber()) {
                    formData.put(key, primitive.getAsNumber());
                } else if (primitive.isBoolean()) {
                    formData.put(key, primitive.getAsBoolean());
                } else {
                    formData.put(key, primitive.toString());
                }
            } else if (!value.isJsonNull()) {
                formData.put(key, gson.toJson(value));
            }
        }
    }

    public Object get(String key) {
        return this.formData.get(key);
    }

    public Object get(String key, Object defaultValue) {
        return has(key) ? get(key) : defaultValue;
    }

    public boolean has(String key) {
        return this.formData.containsKey(key);
    }

    public Collection<String> keys() {
        return this.formData.keySet();
    }

    public Map<String, Object> get() {
        return new HashMap<>(this.formData);
    }

}
