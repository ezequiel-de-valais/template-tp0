package ar.fiuba.tdd.template.tp0;

import ar.fiuba.tdd.template.tp0.CharacterGenerator.AnyCaracter;
import ar.fiuba.tdd.template.tp0.CharacterGenerator.Literal;
import ar.fiuba.tdd.template.tp0.Quantifier.NoneMultiplier;

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
            }else if (AnyCaracter.match(regEx)) {
                AnyCaracter.shift(regEx);
                int multiplier = getMultiplier(regEx);
                buf.append(AnyCaracter.solve(multiplier));
            }
        }
        regEx.refresh();
        return buf.toString();
    }

    private int getMultiplier(Expression regEx) {
        if (NoneMultiplier.match(regEx)) {
            return NoneMultiplier.getMultiplier();
        }

        return 0;
    }
}