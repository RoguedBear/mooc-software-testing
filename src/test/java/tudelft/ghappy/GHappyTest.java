package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
- Happy (even g's)
- Not happy (uneven g's)
- no exist
 */
public class GHappyTest {
    private GHappy gHappy;

    @BeforeEach
    public void init() {
        this.gHappy = new GHappy();
    }

    @DisplayName("G's are happy")
    @ParameterizedTest
    @CsvSource({"....gg...gg...", "..gg..", "...ggg...", "..gggggggg..."})
    public void happyG(String input) {
        boolean result = gHappy.gHappy(input);
        Assertions.assertTrue(result);
    }

    @DisplayName("G's are unhappy")
    @ParameterizedTest
    @CsvSource({"....g...gg...", "..g.g..", "...g...", "..g.g.g.g.g.g.gg..."})
    public void unhappyG(String input) {
        boolean result = gHappy.gHappy(input);
        Assertions.assertFalse(result);
    }

    @DisplayName("G's don't exist")
    @ParameterizedTest
    @CsvSource({"......", ".", "null", "abc"})
    public void GDontExist(String input) {
        boolean result = gHappy.gHappy(input);
        Assertions.assertTrue(result);
    }

    @DisplayName("Only Gs in the string")
    @ParameterizedTest
    @CsvSource({"gg,true", "g, false", "gggggggg, true"})
    public void onlyGs(String input, boolean expected) {
        boolean result = gHappy.gHappy(input);
        Assertions.assertEquals(expected, result);
    }

}
