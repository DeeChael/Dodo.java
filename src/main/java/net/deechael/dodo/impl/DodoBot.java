package net.deechael.dodo.impl;

import net.deechael.dodo.api.Bot;
import net.deechael.dodo.api.Client;
import net.deechael.dodo.event.Listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DodoBot implements Bot {

    private final static Logger LOGGER = LoggerFactory.getLogger(DodoBot.class);

    private final Client client;

    private final List<Runnable> runAfters = new ArrayList<>();

    public DodoBot(int clientId, String token) {
        this.client = new ClientImpl(clientId, token);
    }

    @Override
    public void start() {
        this.client.start();
        while (true) {
            synchronized ((Object) this.client.isStart()) {
                if (this.client.isStart())
                    break;
            }
        }
        LOGGER.debug("Starting running \"runAfters\"");
        for (Runnable runnable : runAfters) {
            try {
                runnable.run();
            } catch (Exception ignored) {
                // Prevent being interrupted
            }
        }
    }

    @Override
    public void runAfter(Runnable runnable) {
        if (this.client.isStart())
            return;
        this.runAfters.add(runnable);
    }

    @Override
    public void addEventListener(Listener listener) {
        this.client.addEventListener(listener);
    }

    @Override
    public Client getClient() {
        return this.client;
    }

}
