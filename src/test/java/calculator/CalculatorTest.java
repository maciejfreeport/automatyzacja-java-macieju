package calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {


    @Test
    public void canAddPositiveIntegers() throws Exception {

        double a = 10.0;
        double b = 5.0;
        double result = calculator.Calculator.add(a, b);

        Assert.assertEquals("10 + 5 = 15", result, 15.0, 0.00);

        Assert.assertTrue("5 + 10 = 15", result == 15);
    }


    @Test
    public void canAddNegativeIntegrers() throws Exception {

        double a = -10.0;
        double b = -5.0;
        double result = calculator.Calculator.add(a, b);

        Assert.assertTrue("-5 + -10 = -15", result == -15);
    }

    @Test
    public void canSubstractPositiveIntegers() throws Exception {

        double a = 10.0;
        double b = 5.0;

        Assert.assertTrue("10 - 5 = 5", calculator.Calculator.substract(a,b) == 5.0);
    }

    @Test
    public void canSubstractNegativeIntegers() throws Exception {

        double a = -10.0;
        double b = -5.0;


        Assert.assertEquals("-5 - -10 = 5", calculator.Calculator.substract(b,a), 5, 0.0);
    }

    @Test
    public void multiplyPositiveIntegers() throws Exception {

        double a = 10.0;
        double b = 5.0;

        Assert.assertTrue("10*5 = 50", calculator.Calculator.multiply(a,b) == 50.0);
    }

    @Test
    public void multiplyByZero() throws Exception {

        double a = 5.0;
        double b = 0.0;

        Assert.assertEquals("5*0 = 0", calculator.Calculator.multiply(a,b), 0, 0.0);
    }

    @Test
    public void dividePositiveIntegers() throws Exception {

        double a = 10.0;
        double b = 5.0;

        Assert.assertTrue("10/5 = 2", calculator.Calculator.divide(a,b) == 2.0);
    }

    @Test
    public void divideByZero() throws Exception {

        double a = 5.0;
        double b = 0.0;

        Assert.assertTrue("5/0 = infinity ", Double.isInfinite(calculator.Calculator.divide(a,b)));
        Assert.assertTrue("5/0 = positive infinity ", calculator.Calculator.divide(a,b) == Double.POSITIVE_INFINITY);
    }

}