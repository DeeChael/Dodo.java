package net.deechael.dodo.network;

import okhttp3.OkHttpClient;

public abstract class Receiver {

    private final OkHttpClient client;
    private final int clientId;
    private final String token;

    public Receiver(OkHttpClient client, int clientId, String token) {
        this.client = client;
        this.clientId = clientId;
        this.token = token;
    }

    public OkHttpClient getClient() {
        return client;
    }

    public int getClientId() {
        return clientId;
    }

    protected String getToken() {
        return this.token;
    }

    public abstract void start();

    public abstract boolean isStart();

}
