package ModernJava.ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    public void testCalculateAddition() throws Exception{
        Calculation calculation = new Addition();
        final int actual = calculation.calculate(1,1);
        assertEquals(2, actual);
    }

    @Test
    public void testCalculateSub() throws Exception{
        Calculation calculation = new  Subtraction();
        final int actual = calculation.calculate(1,1);
        assertEquals(0, actual);
    }
    @Test
    public void testCalculateMultiplication() throws Exception{
        Calculation calculation =  new Multiplication();
        final int actual = calculation.calculate(1,1);
        assertEquals(1, actual);
    }
    @Test
    public void testCalculateDivision() throws Exception{
        Calculation calculation = new Division();
        final int actual = calculation.calculate(8,2);
        assertEquals(4, actual);
    }
}