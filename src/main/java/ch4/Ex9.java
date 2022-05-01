package ch4;

public class Ex9 {
    public static String toString(Object object) {
        StringBuilder stringBuilder = new StringBuilder();

        var objectClass = object.getClass();

        for (var field : objectClass.getDeclaredFields()) {
            if (!field.getType().getName().equals(objectClass.getName())) {
                stringBuilder.append(field.getName());
                stringBuilder.append(" = ");

                try {
                    stringBuilder.append(field.get(object));
                } catch (IllegalAccessException e) {
                    stringBuilder.append("unable to access");
                }

                stringBuilder.append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
