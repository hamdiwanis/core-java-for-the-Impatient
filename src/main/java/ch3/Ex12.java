package ch3;

import java.io.File;

public class Ex12 {
    public static String[] listFilesInDirectoryWithExtension(String pathname, String extension) {
        return new File(pathname).list((_file, name) -> name.endsWith(extension));
    }
}
