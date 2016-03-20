package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by ezequiel on 19/03/16.
 */
public class QuantityIdentifier {

    private static int quantity;
    private static int random_limit = 10;


    public static void identify(Expression regEx) {
        if (regEx.getChar(0).equals("?")) {
            regEx.shift(1);
            Random randomGenerator = new Random();
            quantity = randomGenerator.nextInt(2);
        } else if (regEx.getChar(0).equals("+")) {
            regEx.shift(1);
            Random randomGenerator = new Random();
            quantity = randomGenerator.nextInt(random_limit) + 1;
        } else if (regEx.getChar(0).equals("*")) {
            regEx.shift(1);
            Random randomGenerator = new Random();
            quantity = randomGenerator.nextInt(random_limit);
        } else {
            quantity = 1;
        }
    }

    public static int getQuantity() {
        return quantity;
    }
}
