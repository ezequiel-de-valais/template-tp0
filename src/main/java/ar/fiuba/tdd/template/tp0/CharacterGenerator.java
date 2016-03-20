package ar.fiuba.tdd.template.tp0;

import java.util.Random;

public class CharacterGenerator {
    public static String generate() {
        StringBuffer buf = new StringBuffer();
        int quantity = QuantityIdentifier.getQuantity();
        for (int iterate = 0; iterate < quantity; iterate++) {
            if (CharacterIdentifier.isAnyCharacter()) {
                buf.append(generateAnyCharacter());
            } else if (CharacterIdentifier.isLiteral()) {
                buf.append(generateLiteral());
            } else if (CharacterIdentifier.isGroup()) {
                buf.append(generateGroup());
            } else if (CharacterIdentifier.isSimpleCharacter()) {
                buf.append(generateSimpleCharacter());
            }
        }
        return buf.toString();
    }

    private static String generateGroup() {
        String group = CharacterIdentifier.getActualString();
        String parts = group.substring(1, group.length() - 1);
        Random randomGenerator = new Random();
        int position = randomGenerator.nextInt(parts.length());
        return Character.toString(parts.charAt(position));
    }

    private static String generateSimpleCharacter() {
        return CharacterIdentifier.getActualString();
    }

    private static String generateLiteral() {
        return CharacterIdentifier.getActualString();
    }

    private static String generateAnyCharacter() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(126 - 32) + 32;
        return Character.toString((char) randomInt);
    }
}
