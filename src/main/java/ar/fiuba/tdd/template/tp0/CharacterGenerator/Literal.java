package ar.fiuba.tdd.template.tp0.CharacterGenerator;

import ar.fiuba.tdd.template.tp0.Expression;

import java.util.Random;

/**
 * Created by ezequiel on 18/03/16.
 */
public class Literal {

    private static String literalChar;

    public static boolean match(Expression regEx) {
        if (regEx.getChar(0).equals("\\")) {
            literalChar = regEx.getChar(1);
            return true;
        }
        return false;
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
