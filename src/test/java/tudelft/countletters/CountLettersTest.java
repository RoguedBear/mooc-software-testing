package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
Test needed:
    - last letter of a word is 'r'
    - last word should be x
 */
public class CountLettersTest {

    @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @ParameterizedTest
    @CsvSource({"cat|dogr,1", "cats|dogr, 2", "cater to cats, 2"})
    public void lastWordLetterIsR(String word, int expected) {
        int words = new CountLetters().count(word);
        Assertions.assertEquals(expected, words);
    }

    @ParameterizedTest
    @CsvSource({"catx or, 1", "catx studies from edx, 1"})
    public void lastLetterIsX(String word, int expected) {
        int words = new CountLetters().count(word);
        Assertions.assertEquals(expected, words);
    }



}