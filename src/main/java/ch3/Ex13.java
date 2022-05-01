package ch3;

import java.io.File;
import java.util.Arrays;

public class Ex13 {
    public static void sortFiles(File[] files) {
        // Arrays.sort(files, Comparator.comparing(File::isFile).thenComparing(File::getPath));
        Arrays.sort(files, (a, b) -> {
            if (a.isFile() != b.isFile()) {
                return Boolean.compare(a.isFile(), b.isFile());
            }

            return a.getPath().compareTo(b.getPath());
        });
    }
}
