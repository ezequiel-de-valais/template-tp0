package ar.fiuba.tdd.template.tp0.character.enerator;

import ar.fiuba.tdd.template.tp0.Expression;

import java.util.Random;

/**
 * Created by ezequiel on 18/03/16.
 */
public class AnyCaracter {

    public static boolean match(Expression regEx) {
        if (regEx.getChar(0).equals(".")) {
            return true;
        }
        return false;
    }

    public static void shift(Expression regEx) {
        regEx.shift(1);
    }

    public static String solve(int quantity) {
        StringBuffer buf = new StringBuffer();
        for (int iterate = 0; iterate < quantity; iterate++) {
            buf.append(randomCharacter());
        }
        return buf.toString();
    }

    private static String randomCharacter() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(126 - 32) + 32;
        return Character.toString((char) randomInt);
    }
}
