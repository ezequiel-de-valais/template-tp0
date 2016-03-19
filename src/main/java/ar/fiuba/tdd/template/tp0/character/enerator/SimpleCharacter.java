package ar.fiuba.tdd.template.tp0.character.enerator;

import ar.fiuba.tdd.template.tp0.Expression;

/**
 * Created by ezequiel on 18/03/16.
 */
public class SimpleCharacter {

    private static String literalChar;

    public static boolean match(Expression regEx) {
        literalChar = regEx.getChar(0);
        return !literalChar.isEmpty();
    }

    public static void shift(Expression regEx) {
        regEx.shift(2);
    }

    public static String solve(int quantity) {
        StringBuffer buf = new StringBuffer();
        for (int iterate = 0; iterate < quantity; iterate++) {
            buf.append(getLiteral());
        }
        return buf.toString();
    }

    private static String getLiteral() {
        return literalChar;
    }
}
