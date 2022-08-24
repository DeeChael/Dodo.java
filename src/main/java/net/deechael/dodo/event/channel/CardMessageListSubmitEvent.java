package net.deechael.dodo.event.channel;

import com.google.gson.*;
import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;

import java.util.ArrayList;
import java.util.List;

public class CardMessageListSubmitEvent extends Event {

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
    private final List<String> listData = new ArrayList<>();

    public CardMessageListSubmitEvent(String id, long timestamp, String islandId, String channelId,
                                      String dodoId, String messageId, Member member, String interactCustomId,
                                      JsonArray array) {
        super(id, EventType.CARD_MESSAGE_LIST_SUBMIT, timestamp);
        this.islandId = islandId;
        this.channelId = channelId;
        this.dodoId = dodoId;
        this.messageId = messageId;
        this.member = member;
        this.interactCustomId = interactCustomId;
        for (JsonElement element : array) {
            listData.add(element.getAsJsonObject().get("name").getAsString());
        }
    }

    public boolean has(String name) {
        return listData.contains(name);
    }

    public List<String> get() {
        return new ArrayList<>(listData);
    }

}
