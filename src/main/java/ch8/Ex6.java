package ch8;

public class Ex6 {
    public static boolean hasLettersOnly(String s) {
        return s.codePoints().allMatch(Character::isAlphabetic);
    }

    public static boolean isValidIdentifier(String s) {
        if (!Character.isJavaIdentifierStart(s.codePointAt(0))) {
            return false;
        }

        return s.substring(1).codePoints().allMatch(Character::isJavaIdentifierPart);
    }
}
