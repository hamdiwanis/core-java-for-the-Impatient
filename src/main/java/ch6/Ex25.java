package ch6;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Ex25 {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(genericDeclaration(Ex25.class.getDeclaredMethod("test", double.class, Object.class)));
    }

    public static <T, E> String test(double value, T type) {
        return "";
    }

    public static String genericDeclaration(Method m) {
        var declaration = new StringBuilder();

        declaration.append(Modifier.toString(m.getModifiers()));

        var typeParameters = m.getTypeParameters();

        if (typeParameters.length > 0) {
            declaration.append(" <");

            for (int i = 0; i < typeParameters.length; i++) {
                declaration.append(typeParameters[i].getName());

                if (i != typeParameters.length - 1) {
                    declaration.append(",");
                }
            }

            declaration.append("> ");
        }


        declaration.append(m.getGenericReturnType());
        declaration.append(" ");

        declaration.append(m.getName());

        declaration.append("(");

        var paramTypes = m.getGenericParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            declaration.append(paramTypes[i]);

            if (i != typeParameters.length - 1) {
                declaration.append(",");
            }
        }

        declaration.append(")");

        declaration.append(" {}");

        return declaration.toString();
    }
}
