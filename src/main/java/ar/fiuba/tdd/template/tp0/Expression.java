package ar.fiuba.tdd.template.tp0;


import java.util.ArrayList;

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

    public String cutBrackets() throws PatternError {
        StringBuffer buf = new StringBuffer();
        boolean scapeNext = false;
        for (int index = 1; index < expression.length(); index++) {
            Character character = expression.charAt(index);
            if (scapeNext) {
                scapeNext = false;
                buf.append(character);
                continue;
            }
            scapeNext = processCharacter(buf, character, index);

        }
        return buf.toString();
    }

    private boolean processCharacter(StringBuffer buf, Character character, int index) throws PatternError {
        boolean scapeNext = false;
        if (character == '\\') {
            scapeNext = true;
        } else if ( getInvalidCharacters().contains(character)) {
            throw new PatternError();
        } else if (character == ']') {
            shift(index + 1);
        } else {
            buf.append(character);
        }
        return scapeNext;
    }


    private ArrayList<Character> getInvalidCharacters() {
        ArrayList<Character> invalidCharacters = new ArrayList<Character>();
        invalidCharacters.add('+');
        invalidCharacters.add('*');
        invalidCharacters.add('?');
        invalidCharacters.add('[');
        return invalidCharacters;
    }

}
