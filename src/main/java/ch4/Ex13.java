package ch4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

public class Ex13 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // using method
        printStaticDoubleValuesTable(Math.class.getMethod("sqrt", double.class), 1, 5, 1);
        printStaticDoubleValuesTable(Double.class.getMethod("toHexString", double.class), 1, 5, 1);

        // using DoubleFunction<Object>
        printStaticDoubleValuesTable(Math::sqrt, 1, 5, 1);
        printStaticDoubleValuesTable(Double::toHexString, 1, 5, 1);
    }


    public static void printStaticDoubleValuesTable(Method method, double lowerBound, double upperBound, double step)
            throws IllegalAccessException, InvocationTargetException {
        if (method == null || !Modifier.isStatic(method.getModifiers())) {
            throw new IllegalArgumentException("A static method is required");
        }

        var parameterTypes = method.getParameterTypes();

        if (parameterTypes.length != 1 ||
                (!parameterTypes[0].equals(double.class) && !parameterTypes[0].equals(Double.class))) {
            throw new IllegalArgumentException("Method should have one double/Double parameter");
        }

        System.out.println("---------------------------------------------------------------");
        for (double inputValue = lowerBound; inputValue <= upperBound; inputValue += step) {
            var result = method.invoke(method.getDeclaringClass(), inputValue);
            System.out.println(inputValue + " -> " + result);
        }
    }

    public static void printStaticDoubleValuesTable(DoubleFunction<Object> method, double lowerBound, double upperBound, double step) {
        System.out.println("---------------------------------------------------------------");
        for (double inputValue = lowerBound; inputValue <= upperBound; inputValue += step) {
            var result = method.apply(inputValue);
            System.out.println(inputValue + " -> " + result);
        }
    }
}
