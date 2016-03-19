package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by ezequiel on 19/03/16.
 */
public class CharacterIdentifier {


    private static boolean isAnyCharacter;
    private static boolean isLiteral;
    private static boolean isSimpleCharacter;
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
        } else {
            isSimpleCharacter = true;
            actualString = regEx.getChar(0);
            regEx.shift(1);
        }

    }

    private static void clearFlags() {
        isAnyCharacter = false;
        isLiteral = false;
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

    public static String getActualString() {
        return actualString;
    }
}
