package net.deechael.dodo.gate;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.deechael.dodo.network.Receiver;
import net.deechael.dodo.network.Requester;
import net.deechael.dodo.network.Route;

public class Gateway {

    private final Requester requester;
    private final Receiver receiver;

    public Gateway(Requester requester, Receiver receiver) {
        this.requester = requester;
        this.receiver = receiver;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public Requester getRequester() {
        return requester;
    }

    public JsonElement executeRequest(Route route) {
        JsonObject result = this.requester.executeRequest(route);
        if (result.has("data")) {
            return result.get("data");
        }
        return new JsonObject();
    }

}
