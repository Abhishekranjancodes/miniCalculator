package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculatorTest {

    @Test
    public void testAddition() {
        assertEquals(8.0, calculator.addition(5.0, 3.0), "5 + 3 should be equal to 8.0");
        assertEquals(-2.0, calculator.addition(3.0, -5.0), "3 + (-5) should be equal to -2.0");
    }

    @Test
    public void testSubtraction() {
        assertEquals(2.0, calculator.subtraction(5.0, 3.0), "5 - 3 should be equal to 2.0");
    }

    @Test
    public void testMultiplication() {
        assertEquals(15.0, calculator.multiplication(5.0, 3.0), "5 * 3 should be equal to 15.0");
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.division(6.0, 3.0), "6 / 3 should be equal to 2.0");
    }

    @Test
    public void testSquareRoot() {
        assertEquals(2.0, calculator.squareRoot(4.0), "Square root of 4 should be equal to 2.0");
        assertEquals(3.0, calculator.squareRoot(9.0), "Square root of 9 should be equal to 3.0");
        assertEquals(4.0, calculator.squareRoot(16.0), "Square root of 16 should be equal to 4.0");
    }
}