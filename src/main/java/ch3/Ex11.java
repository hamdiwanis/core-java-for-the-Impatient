package ch3;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex11 {
    public static List<File> listSubdirectories(String pathname) {
        // var subdirectories = new File(pathname).listFiles(file -> file.isDirectory());
        // var subdirectories = new File(pathname).listFiles(File::isDirectory);
        var subdirectories = new File(pathname).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (subdirectories == null) {
            return null;
        }

        return new ArrayList<>(Arrays.asList(subdirectories));
    }
}
