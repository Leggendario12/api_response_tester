package com.montecillo.curltojava;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class JavaCurlExample {
    public static String inputStreamToString(InputStream inputStream) {
        final int bufferSize = 8 * 1024;
        byte[] buffer = new byte[bufferSize];
        final StringBuilder builder = new StringBuilder();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, bufferSize)) {
            while (bufferedInputStream.read(buffer) != -1) {
                builder.append(new String(buffer));
            }
        } catch (IOException ex) {
            Logger.getLogger(JavaCurlExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.toString();
    }

    public static void consumeInputStream(InputStream inputStream) {
        inputStreamToString(inputStream);
    }
}
