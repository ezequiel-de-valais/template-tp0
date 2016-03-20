package ar.fiuba.tdd.template.tp0;


public class CharacterIdentifier {


    private static boolean isAnyCharacter;
    private static boolean isLiteral;
    private static boolean isSimpleCharacter;
    private static boolean isGroup;
    private static String actualString;

    public static void identify(Expression regEx) {
        clearFlags();
        if (regEx.getChar(0).equals(".")) {
            isAnyCharacter = true;
            regEx.shift(1);
        } else if (regEx.getChar(0).equals("\\")) {
            isLiteral = true;
            actualString = regEx.getChar(1);
            regEx.shift(2);
        } else if (regEx.getChar(0).equals("[")) {
            actualString = regEx.cutUpTo("]");
            isGroup = true;
        } else {
            isSimpleCharacter = true;
            actualString = regEx.getChar(0);
            regEx.shift(1);
        }

    }

    private static void clearFlags() {
        isAnyCharacter = false;
        isLiteral = false;
        isGroup = false;
        isSimpleCharacter = false;
    }

    public static boolean isAnyCharacter() {
        return isAnyCharacter;
    }

    public static boolean isLiteral() {
        return isLiteral;
    }

    public static boolean isSimpleCharacter() {
        return isSimpleCharacter;
    }

    public static boolean isGroup() {
        return isGroup;
    }

    public static String getActualString() {
        return actualString;
    }
}
