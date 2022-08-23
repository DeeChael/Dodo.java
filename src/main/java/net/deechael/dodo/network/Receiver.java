package net.deechael.dodo.network;

import okhttp3.OkHttpClient;

public abstract class Receiver {

    private final OkHttpClient client;
    private final String token;

    public Receiver(OkHttpClient client, String token) {
        this.client = client;
        this.token = token;

        //OkHttpClient client = new OkHttpClient.Builder().build();
    }

    public OkHttpClient getClient() {
        return client;
    }

    protected String getToken() {
        return this.token;
    }

    public abstract void start();

}
