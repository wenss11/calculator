package com.company.calculator.operation;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

public class BaseOperationTest {

    @Test
    public void operate() {
        try {
            BaseOperation baseOperation = new BaseOperation();

            Stack<Double> stkNum = new Stack<>();
            Stack<List<Double>> stkLog = new Stack<>();

            //正常测试
            stkNum.push(1.0);
            stkNum.push(-2.0);
            boolean result1 = baseOperation.operate(stkNum, stkLog, "+", 0);
            Assert.assertTrue(result1);
            Assert.assertTrue(stkNum.peek()==-1);
            stkNum.push(1.0);
            boolean result2 = baseOperation.operate(stkNum, stkLog, "-", 0);
            Assert.assertTrue(result2);
            Assert.assertTrue(stkNum.peek()==-2);
            stkNum.push(1.0);
            boolean result3 = baseOperation.operate(stkNum, stkLog, "*", 0);
            Assert.assertTrue(result3);
            Assert.assertTrue(stkNum.peek()==-2);
            stkNum.push(1.0);
            boolean result4 = baseOperation.operate(stkNum, stkLog, "/", 0);
            Assert.assertTrue(result4);
            Assert.assertTrue(stkNum.peek()==-2);

            //操作数不足
            boolean result5 = baseOperation.operate(stkNum, stkLog, "+", 0);
            Assert.assertTrue(!result5);
            Assert.assertTrue(stkNum.size()==1);

            //除数为0
            try {
                stkNum.push(0.0);
                baseOperation.operate(stkNum, stkLog, "/", 0);
                Assert.fail("Expected an ArithmeticException to be thrown");
            } catch (ArithmeticException e) {
                Assert.assertEquals(e.getMessage(),"/ by zero!");
            }

            //操作符异常
            try {
                stkNum.push(1.0);
                stkNum.push(1.0);
                baseOperation.operate(stkNum, stkLog, "@", 0);
                Assert.fail("Expected an IllegalArgumentException to be thrown");
            } catch (IllegalArgumentException e) {
                Assert.assertEquals(e.getMessage(),"Illegal RPN Operation: @");
            }

        } catch (Exception e) {
        e.printStackTrace();
        }

    }
}