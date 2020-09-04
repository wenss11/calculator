package com.company.calculator.operation;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * The {@code ClearOperation} test class
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class ClearOperationTest {

    @Test
    public void testOperate() {
        ClearOperation clearOperation = new ClearOperation();

        Stack<Double> stkNum = new Stack<>();
        Stack<List<Double>> stkLog = new Stack<>();

        //normal test
        stkNum.push(1.0);
        stkNum.push(-2.0);
        boolean result1 = clearOperation.operate(stkNum, stkLog, "clear", 0);
        Assert.assertTrue(result1);
        Assert.assertTrue(stkNum.size()==0);

        //illegal operator
        try {
            clearOperation.operate(stkNum, stkLog, "@", 0);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(),"Illegal RPN Operation: @");
        }

    }
}