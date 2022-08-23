package net.deechael.dodo.api;

public interface Bot {

    void start();

    void shutdown();

    User me();

    Client getClient();

}
