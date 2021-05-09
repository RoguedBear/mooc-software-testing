package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
Partitions:
    - Boundary
        - near a,b,c
        - near x,y,z
    - combination returns Invalid
    - positive shift
    - negative shift
    - 0 shift
    - greater than 26 shift
    - message with spaces
    - message without spaces
    - 0-length string
To test:
    - message w/ spaces + positive shift
    - message w/ spaces + negative shift

    - message w/o spaces + negative shift

    - message with numbers (Invalid)

    - a,b,c w/ negative shift
    - x,y,z w/ positive shift

    - 0-length shift or message

 */
public class CaesarShiftCipherTest {

    private CaesarShiftCipher cryptor;

    @BeforeEach
    public void init() {
        this.cryptor = new CaesarShiftCipher();
    }

    @ParameterizedTest
    @CsvSource({"hello, 1, ifmmp", "hello, -1, gdkkn"})
    public void messageWithoutSpaces(String message, int shift, String expected) {
        String result = cryptor.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"hello there, 1, ifmmp uifsf", "hello there, -1, gdkkn sgdqd"})
    public void messageWithSpaces(String message, int shift, String expected) {
        String result = cryptor.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"hello there., 1,invalid", "123, 23, invalid"})
    public void messageWithInvalidCombination(String message, int shift, String expected) {
        String result = cryptor.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"abc, -2, yza", "xyz, 3,abc", "abc,26,abc"})
    public void BoundaryCases(String message, int shift, String expected) {
        String result = cryptor.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"'',2,''", "hello there, 0, hello there"})
    public void ZeroLength_MessageOrShift(String message, int shift, String expected) {
        String result = cryptor.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"abc ,27,bcd "})
    public void GreaterThan26Shift(String message, int shift, String expected) {
        String result = cryptor.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }
}
