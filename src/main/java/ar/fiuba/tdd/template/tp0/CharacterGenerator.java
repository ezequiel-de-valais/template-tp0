package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        boolean valid = false;
        Random randomGenerator;
        int randomInt;
        String result = "";

        while (!valid) {
            randomGenerator = new Random();
            randomInt = randomGenerator.nextInt(255);
            result = Character.toString((char) randomInt);
            valid = validate(result);
        }



        return result;
    }

    private static boolean validate(String result) {
        try {
            ArrayList<String> invalidChars = getInvalidChars();
            if (invalidChars.contains(result)) {
                return false;
            }
            Pattern pattern = Pattern.compile("^" + result + "$");
            Matcher matcher = pattern.matcher(result);
            boolean solution = matcher.find();

            if (solution == false) {
                solution = false;
            }
            return solution;
        } catch (Exception e) {
            return false;
        }
    }

    private static ArrayList<String> getInvalidChars() {
        ArrayList<String> characters = new ArrayList<String>();
        characters.add("\n");
        characters.add("\t");
        characters.add("\r");
        characters.add(Character.toString((char) 133));
        return characters;
    }


}
