package ch5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(new File("input"));
            out = new PrintWriter("output");

            while (in.hasNext())
                out.println(in.next().toLowerCase());
        } catch (FileNotFoundException e) {
            System.err.println("No such file exist");
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
