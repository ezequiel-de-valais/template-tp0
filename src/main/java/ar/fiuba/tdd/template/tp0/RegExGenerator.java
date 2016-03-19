package ar.fiuba.tdd.template.tp0;

import ar.fiuba.tdd.template.tp0.character.enerator.AnyCaracter;
import ar.fiuba.tdd.template.tp0.character.enerator.Literal;
import ar.fiuba.tdd.template.tp0.character.enerator.SimpleCharacter;
import ar.fiuba.tdd.template.tp0.quantifier.NoneMultiplier;
import ar.fiuba.tdd.template.tp0.quantifier.ZeroOrNoneMultiplier;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {
    // TODO: Uncomment this field
    //private int maxLength;

    //public RegExGenerator(int maxLength) {
    //    this.maxLength = maxLength;
    //}

    public List<String> generate(String regEx, int numberOfResults) {
        Expression expression = new Expression(regEx);
        int iterator;
        ArrayList<String> list = new ArrayList<>();
        for (iterator = 0; iterator < numberOfResults; iterator++) {
            list.add(generateAnExp(expression));
        }
        return list;
    }

    private String generateAnExp(Expression regEx) {
        StringBuffer buf = new StringBuffer();

        while (regEx.hasNext()) {

            if (Literal.match(regEx)) {
                Literal.shift(regEx);
                int multiplier = getMultiplier(regEx);
                buf.append(Literal.solve(multiplier));
            } else if (AnyCaracter.match(regEx)) {
                AnyCaracter.shift(regEx);
                int multiplier = getMultiplier(regEx);
                buf.append(AnyCaracter.solve(multiplier));
            } else if (SimpleCharacter.match(regEx)) {
                SimpleCharacter.shift(regEx);
                int multiplier = getMultiplier(regEx);
                buf.append(SimpleCharacter.solve(multiplier));
            }

        }
        regEx.refresh();
        return buf.toString();
    }

    private int getMultiplier(Expression regEx) {
        if (ZeroOrNoneMultiplier.match(regEx)) {
            return ZeroOrNoneMultiplier.getMultiplier();
        } else {
            return NoneMultiplier.getMultiplier();
        }
    }
}