package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralTest {


    private RomanNumeral roman;

    @BeforeEach
    public void initialise() {
        this.roman = new RomanNumeral();
    }

    @Test
    public void singleNumber() {
        int result = this.roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        int result = this.roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        int result = this.roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        int result = this.roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }
}
