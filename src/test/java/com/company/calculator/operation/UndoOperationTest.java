package com.company.calculator.operation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The {@code UndoOperation} test class
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class UndoOperationTest {

    @Test
    public void testOperate() {

        UndoOperation undoOperation = new UndoOperation();

        Stack<Double> stkNum = new Stack<>();
        Stack<List<Double>> stkLog = new Stack<>();

        //normal test
        stkNum.push(1.0);
        stkNum.push(-2.0);
        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(3.0);
        stkLog.push(list1);
        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(1.0);
        list2.add(2.0);
        stkLog.push(list2);
        boolean result1 = undoOperation.operate(stkNum, stkLog, "undo", 0);
        Assert.assertTrue(result1);
        Assert.assertTrue(stkNum.size()==1);
        Assert.assertTrue(stkNum.peek()==3);

        //illegal operator
        try {
            undoOperation.operate(stkNum, stkLog, "@", 0);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(),"Illegal RPN Operation: @");
        }
    }
}