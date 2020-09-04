package com.company.calculator.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class to calculate the clear operation
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class ClearOperation implements IOperation {

    /**
     * The clear operation
     *
     * @param stkNum the stack to store the number for calculation
     * @param stkLog the stack to record the historical data in the {@code stkNum}
     * @param opt operator for calculation
     * @param currIndex The current operator's index at the RPN expression
     * @return the operation successful or failure
     * @throws IllegalArgumentException if the {@code opt} is not the correct operator
     */
    @Override
    public boolean operate(Stack<Double> stkNum, Stack<List<Double>> stkLog, String opt, int currIndex) throws IllegalArgumentException {
        boolean flag = true;
        switch (opt) {
            case "clear":
                clear(stkNum,stkLog);
                break;
            default:
                flag = false;
                throw new IllegalArgumentException("Illegal RPN Operation: "+opt);
        }
        return flag;
    }

    /**
     * Delete all the data of {@code stkNum} and push a record to {@code sktLog}
     *
     * @param stkNum the stack to store the number for calculation
     * @param stkLog the stack to record the historical data in the {@code stkNum}
     */
    private void clear(Stack<Double> stkNum, Stack<List<Double>> stkLog) {
        while (!stkNum.empty()) {
            stkNum.pop();
        }
        List<Double> list2 = new ArrayList<>();
        list2.add(null);
        stkLog.push(list2);
    }
}
