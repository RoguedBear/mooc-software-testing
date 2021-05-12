package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/*
possible tests:
    - Equal digits,
    - Unequal Digits,
    - zero
    - one digit
    - more than one digit
    - over 10
 */
public class TwoNumbersSumTest {

    @Test
    public void SumEqualDigits() {
        ArrayList<Integer> number1 = new ArrayList<Integer>(4);
        number1.add(1);
        number1.add(2);
        number1.add(3);
        number1.add(4);

        ArrayList<Integer> number2 = new ArrayList<Integer>(4);
        number2.add(2);
        number2.add(3);
        number2.add(4);
        number2.add(5);

        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(number1, number2);

        Assertions.assertEquals(new ArrayList<Integer>(Arrays.asList(3, 5, 7, 9)), result);
    }

    @Test
    public void UnequalDigits() {
        ArrayList<Integer> number1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> number2 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(number1, number2);

        Assertions.assertEquals(new ArrayList<Integer>(Arrays.asList(1, 3, 5)), result);
    }
    @Test
    public void Over10PLusOneLoop() {
        ArrayList<Integer> number1 = new ArrayList<>(Arrays.asList(9));
        ArrayList<Integer> number2 = new ArrayList<>(Arrays.asList(9));
        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(number1, number2);

        Assertions.assertEquals(new ArrayList<Integer>(Arrays.asList(1, 8)), result);
    }

    @Test
    public void ZeroLoop() {
        ArrayList<Integer> number1 = new ArrayList<>();
        ArrayList<Integer> number2 = new ArrayList<>();
        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(number1, number2);

        Assertions.assertEquals(new ArrayList<Integer>(), result);
    }



}
