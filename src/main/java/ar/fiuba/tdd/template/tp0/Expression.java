package ar.fiuba.tdd.template.tp0;

/**
 * Created by ezequiel on 18/03/16.
 */
public class Expression {
    private static final String EMPTY_STRING = "";
    private final String saveExpression;
    String expression;

    public Expression(String expression) {
        this.expression = expression;
        this.saveExpression = expression;
    }

    public boolean hasNext() {
        return expression.length() > 0;

    }

    public void shift(int shiftNumber) {
        expression = expression.substring(shiftNumber);
    }

    public void refresh() {
        expression = saveExpression;
    }

    public String getChar(int index) {
        if (expression.length() > index ) {
            return expression.substring(index,index + 1);
        }
        return EMPTY_STRING;
    }

    public String cutUpTo(String limit) {
        int position = expression.indexOf(limit);
        String substring  = expression.substring(0, position + 1);
        shift(position + 1);
        return substring;
    }
}
