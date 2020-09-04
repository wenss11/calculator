package com.company.calculator.operation;

import java.util.List;
import java.util.Stack;

/**
 * The interface of all operations
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public interface IOperation {

    /**
     * According to this method, users can realize their own specific computing functions
     *
     * @param stkNum the stack to store the number for calculation
     * @param stkLog the stack to record the historical data in the {@code stkNum}
     * @param opt operator for calculation
     * @param currIndex The current operator's {@code opt} index at the initial expression
     * @return the operation successful or failure
     */
    boolean operate(Stack<Double> stkNum, Stack<List<Double>> stkLog, String opt, int currIndex) throws Exception;

}
