package ar.fiuba.tdd.template.tp0.quantifier;

import ar.fiuba.tdd.template.tp0.Expression;

import java.util.Random;

/**
 * Created by ezequiel on 18/03/16.
 */
public class ZeroOrNoneMultiplier {


    private static int multiplier = 1;

    public static boolean match(Expression regEx) {
        if (regEx.getChar(0).equals("?")) {
            regEx.shift(1);
            return true;
        }
        return false;
    }

    public static int getMultiplier() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(2);
    }
}
