package net.deechael.dodo.impl;

import com.google.gson.JsonObject;
import lombok.Getter;
import net.deechael.dodo.api.Message;
import net.deechael.dodo.api.User;
import net.deechael.dodo.gate.Gateway;

public abstract class MessageImpl extends RawMessageImpl implements Message {

    @Getter
    private User author;

    public MessageImpl(Gateway gateway, JsonObject object) {
        super(gateway, object);
        // TODO: author = new User();
    }

}
