package net.deechael.dodo.api;

import net.deechael.dodo.event.Listener;

public interface Bot {

    void start();

    void runAfter(Runnable runnable);

    void addEventListener(Listener listener);

    Client getClient();

}
