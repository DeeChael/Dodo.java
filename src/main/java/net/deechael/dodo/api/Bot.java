package net.deechael.dodo.api;

import net.deechael.dodo.command.DodoCommand;
import net.deechael.dodo.event.Listener;

public interface Bot {

    /**
     * Start the bot
     */
    void start();

    /**
     * When run the task after the websocket has started
     * @param runnable task
     */
    void runAfter(Runnable runnable);

    /**
     * Add an event listener
     * @param listener event listener
     */
    void addEventListener(Listener listener);

    /**
     * Unregister an event listener
     * @param listener event listener
     */
    void unregisterEventListener(Listener listener);

    /**
     * Register a command
     * @param command dodo command
     */
    void registerCommand(DodoCommand command);

    /**
     * Get the client
     * @return client
     */
    Client getClient();

}
