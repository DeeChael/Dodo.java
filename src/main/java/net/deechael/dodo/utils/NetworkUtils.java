package net.deechael.dodo.utils;

import okio.ByteString;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.zip.InflaterOutputStream;

public final class NetworkUtils {

    public static String byteString2String(ByteString bstr) {
        ByteBuffer buffer = ByteBuffer.wrap(bstr.toByteArray());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (OutputStream ios = new InflaterOutputStream(outputStream)) {
            ios.write(buffer.array());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(ByteBuffer.wrap(outputStream.toByteArray()).array(), StandardCharsets.UTF_8);
    }

    private NetworkUtils() {}

}
