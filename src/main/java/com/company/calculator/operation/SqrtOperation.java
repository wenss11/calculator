package com.company.calculator.operation;

import com.company.calculator.utils.StackUtils;

import java.util.List;
import java.util.Stack;

/**
 * This class to calculate the sqrt operation
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class SqrtOperation implements IOperation {

    /**
     * The sqrt operation
     *
     * @param stkNum the stack to store the number for calculation
     * @param stkLog the stack to record the historical data in the {@code stkNum}
     * @param opt operator for calculation
     * @param currIndex The current operator's index at the RPN expression
     * @return the operation successful or failure
     * @throws IllegalArgumentException if the {@code opt} is not the correct operator
     * @throws ArithmeticException if the number to operate is negative
     */
    @Override
    public boolean operate(Stack<Double> stkNum, Stack<List<Double>> stkLog, String opt, int currIndex) throws IllegalArgumentException {

        boolean flag = true;
        if (stkNum.size() < 1) {
            System.out.println("operator [" + opt + "] (position:" + (2 * currIndex + 1) + "):insufficient parameters ");
            flag = false;
            return flag;
        }
        double num = stkNum.pop();
        switch (opt) {
            case "sqrt":
                stkNum.push(sqrt(num));
                stkLog.push(StackUtils.getStack(stkNum));
                break;
            default:
                flag = false;
                throw new IllegalArgumentException("Illegal RPN Operation: "+opt);
        }
        return flag;
    }

    /**
     * square root of number
     *
     * @param num initial value
     * @return  result value
     * @throws ArithmeticException if the number {@code f} is negative
     */
    private double sqrt(double num) throws ArithmeticException {
        if (num < 0) {
            throw new ArithmeticException("Negative numbers cannot be squared !");
        }
        return (double) Math.sqrt(num);
    }
}
