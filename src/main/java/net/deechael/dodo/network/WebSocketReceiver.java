package net.deechael.dodo.network;

import net.deechael.dodo.utils.NetworkUtils;
import okhttp3.*;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketReceiver extends Receiver {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebSocketReceiver.class);

    private PacketListener listener = new PacketListener(this);
    private WebSocket webSocket;

    public WebSocketReceiver(OkHttpClient client, String token) {
        super(client, token);
    }

    @Override
    public void start() {
    }

    private static final class PacketListener extends WebSocketListener {

        private final WebSocketReceiver receiver;

        public PacketListener(WebSocketReceiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
            LOGGER.debug("Connected successfully");
        }

        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
            // TODO
        }

        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
            this.onMessage(webSocket, NetworkUtils.byteString2String(bytes));
        }

        @Override
        public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
            LOGGER.debug("WebSocket connection has been closed");
        }

        @Override
        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable throwable, Response response) {
            LOGGER.debug("Failed to connect to websocket");
        }

    }

}
