package net.deechael.dodo.api;

import net.deechael.dodo.command.DodoCommand;
import net.deechael.dodo.event.Listener;

public interface Bot {

    void start();

    void runAfter(Runnable runnable);

    void addEventListener(Listener listener);

    void registerCommand(DodoCommand command);

    Client getClient();

}
