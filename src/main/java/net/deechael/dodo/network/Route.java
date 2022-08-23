package net.deechael.dodo.network;

public class Route {

    private final String method;

    private final String route;

    public Route(String method, String url) {
        this.method = method;
        this.route = url;
    }

    // Dodo's requests must use POST
    public String getMethod() {
        return "POST";
    }

    public String getRoute() {
        return route;
    }

}
