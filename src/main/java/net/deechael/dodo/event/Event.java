package net.deechael.dodo.event;

import lombok.Getter;
import net.deechael.dodo.types.EventType;

public abstract class Event {

    @Getter
    private final String id;
    @Getter
    private final EventType type;
    @Getter
    private final long timestamp;

    public Event(String id, EventType type, long timestamp) {
        this.id = id;
        this.type = type;
        this.timestamp = timestamp;
    }

}
