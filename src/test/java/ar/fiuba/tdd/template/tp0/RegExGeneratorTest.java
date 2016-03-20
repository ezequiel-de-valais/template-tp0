package ar.fiuba.tdd.template.tp0;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegExGeneratorTest {

    private final int repetitions = 300;
    private final int limit = 10;

    private boolean validate(String regEx, int numberOfResults) {
        RegExGenerator generator = new RegExGenerator(limit);
        List<String> results = generator.generate(regEx, numberOfResults);
        // force matching the beginning and the end of the strings
        Pattern pattern = Pattern.compile("^" + regEx + "$");
        return results
                .stream()
                .reduce(true,
                    (acc, item) -> {
                        Matcher matcher = pattern.matcher(item);
                        return  acc && matcher.find();
                    },
                    (item1, item2) -> item1 && item2);
    }


    @Test
    public void testAnyCharacter() {
        assertTrue(validate(".", repetitions));
    }

    @Test
    public void resultNumber() {
        RegExGenerator generator = new RegExGenerator(limit);
        List<String> results;
        results = generator.generate(".", 2);
        assertEquals(results.size(), 2 );
        results = generator.generate("..", 5);
        assertEquals(results.size(), 5 );
    }

    @Test
    public void resultLengthFixesToLimit() {
        int limit = 5;
        RegExGenerator generator = new RegExGenerator(limit);
        List<String> results;
        results = generator.generate(".*", 100);
        boolean solution = true;
        for (String result : results) {
            if (result.length() > (limit - 1)) {
                solution = false;
            }
        }
        assertTrue(solution);
    }

    @Test
    public void testMultipleCharacters() {
        assertTrue(validate("...", repetitions));
    }

    @Test
    public void testLiteral() {
        assertTrue(validate("\\@", repetitions));
    }

    @Test
    public void testLiteralDotCharacter() {
        assertTrue(validate("\\@..", repetitions));
    }


    @Test
    public void testZeroOrOneCharacter() {
        assertTrue(validate("\\@.h?", repetitions));
    }


    @Test
    public void testCharacterSet() {
        assertTrue(validate("[abc]", repetitions));
    }

    @Test
    public void testCharacterSetWithQuantifiers() {
        assertTrue(validate("[abc]+", repetitions));
    }

    @Test
    public void testCharacterSetWithQuantifiersCeroOrLot() {
        assertTrue(validate("[abc]*", repetitions));
    }

    @Test
    public void testComplexRegExp() {
        assertTrue(validate("..+[ab]*d?c", repetitions));
    }
}
