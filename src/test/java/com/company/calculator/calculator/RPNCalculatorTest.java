package com.company.calculator.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The {@code RPNCalculator} test class
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class RPNCalculatorTest {

    ICalculator calculator = null;

    @Before
    public void testBefore(){
        calculator = new RPNCalculator();
    }

    @Test
    public void testCalcultor() {

        //test data
        String clear = "clear";
        String rpn1= "5 2";
        String rpn2= "clear 2 sqrt";
        String rpn3= "clear 2 sqrt clear 9 sqrt";
        String rpn4= "clear 5 2 - 3 -";
        String rpn5= "clear 5 4 3 2 undo undo * 5 * undo";
        String rpn6= "clear 7 12 2 / * 4 /";
        String rpn7= "clear 1 2 3 4 5 * clear 3 4 -";
        String rpn8= "clear 1 2 3 4 5 * * * *";
        String rpn9= "clear 1 2 3 * 5 + * * 6 5";

        Assert.assertEquals(calculator.calcultor(clear),"");
        Assert.assertEquals(calculator.calcultor(rpn1),"5 2");
        Assert.assertEquals(calculator.calcultor(rpn2),"1.4142135623");
        Assert.assertEquals(calculator.calcultor(rpn3),"3");
        Assert.assertEquals(calculator.calcultor(rpn4),"0");
        Assert.assertEquals(calculator.calcultor(rpn5),"20 5");
        Assert.assertEquals(calculator.calcultor(rpn6),"10.5");
        Assert.assertEquals(calculator.calcultor(rpn7),"-1");
        Assert.assertEquals(calculator.calcultor(rpn8),"120");
        Assert.assertEquals(calculator.calcultor(rpn9),"11");

    }

}