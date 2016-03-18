package ar.fiuba.tdd.template.tp0;

/**
 * Created by ezequiel on 18/03/16.
 */
public class Expression {
    String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public boolean hasNext() {
        return expression.length() > 0;

    }

    public void shift(int shiftNumber) {
        expression = expression.substring(shiftNumber);
    }
}
