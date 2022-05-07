package ch9;

import java.util.Arrays;

public class Ex11 {
    public static void main(String[] args) {
        var testPath = "/home\\cay//myfile.txt";

        var pathParts = testPath.split("[/\\\\]+");
        var dirs = Arrays.stream(Arrays.copyOfRange(pathParts, 0, pathParts.length - 1))
                .filter(s -> !s.trim().equals(""))
                .toArray(String[]::new);

        var file = pathParts[pathParts.length - 1];
        var lastDotIndex = file.lastIndexOf(".");
        String fileName, extension;

        if (lastDotIndex != -1) {
            fileName = file.substring(0, lastDotIndex);
            extension = file.substring(lastDotIndex + 1);
        } else {
            fileName = file;
            extension = null;
        }


        System.out.println(Arrays.toString(dirs));
        System.out.println(fileName);
        System.out.println(extension);
    }
}
