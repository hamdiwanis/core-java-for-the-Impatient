package ch8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex2 {
    public static void countLongWords(boolean isSequential) throws FileNotFoundException {
        var in = new Scanner(new File("war_and_peace.txt"));
        in.useDelimiter("\\PL+");

        var words = in.tokens();

        if (isSequential) {
            words = words.sequential();
        } else {
            words = words.parallel();
        }

        long start = System.currentTimeMillis();

        words.filter(w -> w.length() > 12).count();

        long end = System.currentTimeMillis();

        System.out.println((isSequential ? "Linear stream   :" : "Parallel stream :") + (end - start) + "ms");
    }

}
