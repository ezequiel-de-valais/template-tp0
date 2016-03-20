package ar.fiuba.tdd.template.tp0;


import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {

    public RegExGenerator(int maxLength) {
        QuantityIdentifier.setLimitRandom(maxLength);
    }

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
            CharacterIdentifier.identify(regEx);
            QuantityIdentifier.identify(regEx);
            buf.append(CharacterGenerator.generate());
        }
        regEx.refresh();
        return buf.toString();
    }
}