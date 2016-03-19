package ar.fiuba.tdd.template.tp0;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegExGeneratorTest {

    private final int repetitions = 300;

    private boolean validate(String regEx, int numberOfResults) {
        RegExGenerator generator = new RegExGenerator();
        List<String> results = generator.generate(regEx, numberOfResults);
        // force matching the beginning and the end of the strings
        Pattern pattern = Pattern.compile("^" + regEx + "$");
        return results
                .stream()
                .reduce(true,
                    (acc, item) -> {
                        Matcher matcher = pattern.matcher(item);
                        return  acc && matcher.find();
                        /*boolean solution =  acc && matcher.find();
                        if(!solution) {
                            solution = false;
                        }
                        return solution;*/
                    },
                    (item1, item2) -> item1 && item2);
    }


    @Test
    public void testAnyCharacter() {
        assertTrue(validate(".", repetitions));
    }

    @Test
    public void resultNumber() {
        RegExGenerator generator = new RegExGenerator();
        List<String> results;
        results = generator.generate(".", 2);
        assertEquals(results.size(), 2 );
        results = generator.generate("..", 5);
        assertEquals(results.size(), 5 );
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

    //TODO: Uncomment these tests
    /*
    @Test
    public void testCharacterSet() {
        assertTrue(validate("[abc]", 1));
    }

    @Test
    public void testCharacterSetWithQuantifiers() {
        assertTrue(validate("[abc]+", 1));
    }
    */
    // TODO: Add more tests!!!
}
