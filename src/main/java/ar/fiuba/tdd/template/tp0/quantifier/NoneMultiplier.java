package ar.fiuba.tdd.template.tp0.quantifier;

import ar.fiuba.tdd.template.tp0.Expression;

/**
 * Created by ezequiel on 18/03/16.
 */
public class NoneMultiplier {


    private static int multiplier = 1;

    public static boolean match(Expression regEx) {
        return true;
    }

    public static int getMultiplier() {
        return multiplier;
    }
}