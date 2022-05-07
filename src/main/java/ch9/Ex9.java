package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Stream;

public class Ex9 {
    public static Stream<String> readProtectedPage(String target, String username, String password) throws IOException {
        var url = new URL(target);
        var connection = url.openConnection();
        connection.setRequestProperty("Authorization", "Basic " + base64Encode(username + ":" + password));

        var pageReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        return pageReader.lines();
    }

    public static String base64Encode(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }
}
