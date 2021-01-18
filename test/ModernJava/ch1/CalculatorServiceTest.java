package ModernJava.ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    public void testCalculateAddition() throws Exception{
        CalculatorService calculatorService = new CalculatorService();
        final int actual = calculatorService.calculate('+',1,1);
        assertEquals(2, actual);
    }

    @Test
    public void testCalculateSub() throws Exception{
        CalculatorService calculatorService = new CalculatorService();
        final int actual = calculatorService.calculate('-',1,1);
        assertEquals(2, actual);
    }
    @Test
    public void testCalculateMultiplication() throws Exception{
        CalculatorService calculatorService = new CalculatorService();
        final int actual = calculatorService.calculate('*',1,1);
        assertEquals(2, actual);
    }
    @Test
    public void testCalculateDivision() throws Exception{
        CalculatorService calculatorService = new CalculatorService();
        final int actual = calculatorService.calculate('/',1,1);
        assertEquals(2, actual);
    }
}