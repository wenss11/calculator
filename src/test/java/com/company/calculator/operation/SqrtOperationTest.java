package com.company.calculator.operation;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * The {@code SqrtOperation} test class
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class SqrtOperationTest {

    @Test
    public void testOperate() {

        SqrtOperation sqrtOperation = new SqrtOperation();

        Stack<Double> stkNum = new Stack<>();
        Stack<List<Double>> stkLog = new Stack<>();

        //normal test
        stkNum.push(4.0);
        boolean result1 = sqrtOperation.operate(stkNum, stkLog, "sqrt", 0);
        Assert.assertTrue(result1);
        Assert.assertTrue(stkNum.peek()==2);
        boolean result2 = sqrtOperation.operate(stkNum, stkLog, "sqrt", 0);
        Assert.assertTrue(result2);
        Assert.assertTrue(stkNum.peek()==1.4142135623730951);

        //insufficient parometers
        stkNum.pop();
        boolean result3 = sqrtOperation.operate(stkNum, stkLog, "sqrt", 0);
        Assert.assertTrue(!result3);
        Assert.assertTrue(stkNum.size()==0);

        //square of negative
        try {
            stkNum.push(-2.0);
            sqrtOperation.operate(stkNum, stkLog, "sqrt", 0);
            Assert.fail("Expected an ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
            Assert.assertEquals(e.getMessage(),"Negative numbers cannot be squared !");
        }

        //illegal operator
        try {
            stkNum.push(4.0);
            sqrtOperation.operate(stkNum, stkLog, "@", 0);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(),"Illegal RPN Operation: @");
        }
    }
}