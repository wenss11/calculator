package com.company.calculator.operation;

import java.util.List;
import java.util.Stack;

/**
 * This class to calculate the undo operation
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class UndoOperation implements IOperation {

    /**
     * The undo operation
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
            case "undo":
                undo(stkNum,stkLog);
                break;
            default:
                flag= false;
                throw new IllegalArgumentException("Illegal RPN Operation: "+opt);
        }
        return flag;
    }

    /**
     * Recover the last data in the {@code stkNum} according to the {@code sktLog}
     *
     * @param stkNum the stack to store the number for calculation
     * @param stkLog the stack to record the historical data in the {@code stkNum}
     */
    private void undo(Stack<Double> stkNum, Stack<List<Double>> stkLog) {
        while (!stkNum.empty()) {
            stkNum.pop();
        }
        if (!stkLog.empty()) {
            stkLog.pop();
            if (!stkLog.empty()) {
                List<Double> list = stkLog.peek();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        stkNum.push(list.get(i));
                    }
                }
            }
        }
    }
}
