package ar.fiuba.tdd.template.tp0;

import java.util.Random;

public class QuantityIdentifier {

    private static int quantity;
    private static int limitRandom = 10;


    public static void identify(Expression regEx) {
        if (regEx.getChar(0).equals("?")) {
            regEx.shift(1);
            Random randomGenerator = new Random();
            quantity = randomGenerator.nextInt(2);
        } else if (regEx.getChar(0).equals("+")) {
            regEx.shift(1);
            Random randomGenerator = new Random();
            quantity = randomGenerator.nextInt(limitRandom) + 1;
        } else if (regEx.getChar(0).equals("*")) {
            regEx.shift(1);
            Random randomGenerator = new Random();
            quantity = randomGenerator.nextInt(limitRandom);
        } else {
            quantity = 1;
        }
    }

    public static int getQuantity() {
        return quantity;
    }

    public static void setLimitRandom(int limitRandom) {
        QuantityIdentifier.limitRandom = limitRandom;
    }
}
