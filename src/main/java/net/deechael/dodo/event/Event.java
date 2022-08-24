package net.deechael.dodo.event;

import lombok.Getter;
import net.deechael.dodo.types.EventType;

public abstract class Event {

    @Getter
    private String id;
    @Getter
    private EventType type;
    @Getter
    private long timestamp;

    public Event(String id, EventType type, long timestamp) {
        this.id = id;
        this.type = type;
        this.timestamp = timestamp;
    }

}
