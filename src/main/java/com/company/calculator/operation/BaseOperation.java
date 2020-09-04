package com.company.calculator.operation;

import com.company.calculator.utils.StackUtils;

import java.util.List;
import java.util.Stack;

/**
 * This class to calculate the basic arithmetic operations, including '+', '-', '*', '/'
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class BaseOperation implements IOperation {

    /**
     * The basic arithmetic operations, including '+', '-', '*', '/'
     *
     * @param stkNum the stack to store the number for calculation
     * @param stkLog the stack to record the historical data in the {@code stkNum}
     * @param opt operator for calculation
     * @param currIndex The current operator's index at the RPN expression
     * @return the operation successful or failure
     * @throws IllegalArgumentException if the {@code opt} is not the correct operator
     * @throws ArithmeticException / by zero
     */
    @Override
    public boolean operate(Stack<Double> stkNum, Stack<List<Double>> stkLog, String opt, int currIndex) throws Exception{
        boolean flag = true;
        if (stkNum.size() < 2) {
            System.out.println("operator [" + opt + "] (position:" + (2 * currIndex + 1) + "):insufficient parameters ");
            flag = false;
            return flag;
        }
        double num2 = stkNum.pop();
        double num1 = stkNum.pop();
        switch (opt) {
            case "+":
                stkNum.push(num1 + num2);
                stkLog.push(StackUtils.getStack(stkNum));
                break;
            case "-":
                stkNum.push(num1 - num2);
                stkLog.push(StackUtils.getStack(stkNum));
                break;
            case "*":
                stkNum.push(num1 * num2);
                stkLog.push(StackUtils.getStack(stkNum));
                break;
            case "/":
                stkNum.push(div(num1, num2));
                stkLog.push(StackUtils.getStack(stkNum));
                break;
            default:
                flag = false;
                throw new IllegalArgumentException("Illegal RPN Operation: "+opt);
        }
        return flag;
    }

    private double div(double a, double b) throws ArithmeticException{
        if (b == 0) {
            throw new ArithmeticException("/ by zero!");
        }
        return a / b;
    }
}
