package ch4;

import java.lang.reflect.InvocationTargetException;

public class Ex12 {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long noReflectionStart = System.nanoTime();
        System.out.println("Hello, World");
        long noReflectionEnd = System.nanoTime();

        long reflectionStart = System.nanoTime();
        Ex11.main(null);
        long reflectionEnd = System.nanoTime();

        System.out.println("----------------------------------------------------");
        System.out.println("With reflection execution in nano second: " + (reflectionEnd - reflectionStart));
        System.out.println("Non reflection execution in nano second:  " + (noReflectionEnd - noReflectionStart));
        System.out.println("----------------------------------------------------");
    }
}
