package ar.fiuba.tdd.template.tp0;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegExGeneratorTest {

    private final int repetitions = 100;
    private final int limit = 10;

    private boolean validate(String regEx, int numberOfResults) throws PatternError {
        RegExGenerator generator = new RegExGenerator(limit);
        List<String> results = generator.generate(regEx, numberOfResults);
        // force matching the beginning and the end of the strings
        Pattern pattern = Pattern.compile("^" + regEx + "$");

        return results
                .stream()
                .reduce(true,
                    (acc, item) -> {
                        Matcher matcher = pattern.matcher(item);
                        return acc && matcher.find();
                    },
                    (item1, item2) -> item1 && item2);
    }


    @Test
    public void testAnyCharacter() throws PatternError {
        assertTrue(validate(".", repetitions));
    }

    @Test
    public void resultNumber() throws PatternError {
        RegExGenerator generator = new RegExGenerator(limit);
        List<String> results;
        results = generator.generate(".", 2);
        assertEquals(results.size(), 2 );
        results = generator.generate("..", 5);
        assertEquals(results.size(), 5 );
    }

    @Test
    public void resultLengthFixesToLimit() throws PatternError {
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
    public void testMultipleCharacters() throws PatternError {
        assertTrue(validate("...", repetitions));
    }

    @Test
    public void testLiteral() throws PatternError {
        assertTrue(validate("\\@", repetitions));
    }

    @Test
    public void testLiteralDotCharacter() throws PatternError {
        assertTrue(validate("\\@..", repetitions));
    }


    @Test
    public void testZeroOrOneCharacter() throws PatternError {
        assertTrue(validate("\\@.h?", repetitions));
    }


    @Test
    public void testCharacterSet() throws PatternError {
        assertTrue(validate("[abc]", repetitions));
    }

    @Test
    public void testCharacterSetWithQuantifiers() throws PatternError {
        assertTrue(validate("[abc]+", repetitions));
    }

    @Test
    public void testCharacterSetWithQuantifiersCeroOrLot() throws PatternError {
        assertTrue(validate("[abc]*", repetitions));
    }

    @Test
    public void testComplexRegExp() throws PatternError {
        assertTrue(validate("..+[ab]*d?c", repetitions));
    }

    @Test(expected = PatternError.class)
    public void testPatternError() throws PatternError {
        validate("[ab+cd]", repetitions);
    }

    @Test
    public void testPatternEscapedInGroup() throws PatternError {
        assertTrue(validate("[ab\\+cd]", repetitions));
    }
}
