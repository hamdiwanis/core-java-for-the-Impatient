package ch9;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ex7 {
    public static String hashFile(String filePath) throws IOException, NoSuchAlgorithmException {
        var messageDigest = MessageDigest.getInstance("SHA-256");

        try (var in = new FileInputStream(filePath)) {
            byte[] bytes;
            do {
                bytes = in.readNBytes(1024);
                messageDigest.update(bytes);
            } while (bytes.length != 0);
        }

        return bytesToHex(messageDigest.digest()).toUpperCase();
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
