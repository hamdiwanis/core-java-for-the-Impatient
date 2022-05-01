package ch4;

import java.lang.reflect.InvocationTargetException;

public class Ex11 {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var systemOutField = java.lang.System.class.getField("out");
        var systemOutPrintln = systemOutField.getType().getDeclaredMethod("println", String.class);

        systemOutPrintln.invoke(systemOutField.get(null), "Hello, World");
    }
}
