package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by ezequiel on 19/03/16.
 */
public class QuantityIdentifier {

    private static int quantity;

    public static void identify(Expression regEx) {
        if (regEx.getChar(0).equals("?")) {
            regEx.shift(1);
            Random randomGenerator = new Random();
            quantity =  randomGenerator.nextInt(2);
        } else {
            quantity = 1;
        }
    }

    public static int getQuantity() {
        return quantity;
    }
}
