package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {
    // TODO: Uncomment this field
    //private int maxLength;

    //public RegExGenerator(int maxLength) {
    //    this.maxLength = maxLength;
    //}

    // TODO: Uncomment parameters
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
            if (AnyCaracter.match(regEx)) {
                AnyCaracter.shift(regEx);
                int multiplier = getMultiplier(regEx);
                buf.append(AnyCaracter.solve(multiplier));
            }
        }
        return buf.toString();
    }

    private int getMultiplier(Expression regEx) {
        if (NoneMultiplier.match(regEx)) {
            return NoneMultiplier.getMultiplier();
        }

        return 0;
    }
}