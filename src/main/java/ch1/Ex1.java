package ch1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            int value = in.nextInt();

            System.out.printf("binary: %s \n", Integer.toBinaryString(value));
            System.out.printf("octal: %o \n", value);
            System.out.printf("hexadecimal: %x \n", value);

            double reciprocal = 1.0 / value;
            System.out.printf("hexadecimal floating point: %a \n", reciprocal);
        } catch (Exception e) {
            System.out.print("unexpected value");
        }
    }
}
