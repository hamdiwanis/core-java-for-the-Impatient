package ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex25 {
    public static String readPage(String url) {
        try {
            URLConnection connection = new URL(url).openConnection();
            StringBuilder content = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line);
                }
            }
            return content.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getLinks(String content) {
        List<String> links = new ArrayList<>();
        Pattern p = Pattern.compile("(?i)href=['\"](https?:\\/\\/.*?)['\"]");
        Matcher m = p.matcher(content);
        while (m.find()) {
            links.add(m.group(1));
        }
        return links;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please Enter A Valid URL");
        String url = in.nextLine();

        String URlRegex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        if (!url.matches(URlRegex)) {
            System.out.println("URL is not valid");
            return;
        }

        CompletableFuture.supplyAsync(() -> readPage(url))
                .thenApply(content -> getLinks(content))
                .whenComplete((links, throwable) -> System.out.println(links))
                .join();
    }
}
