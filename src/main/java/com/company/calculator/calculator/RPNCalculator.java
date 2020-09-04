package com.company.calculator.calculator;

import com.company.calculator.utils.StackUtils;
import com.company.calculator.factory.*;
import java.util.List;
import java.util.Stack;

/**
 * The main class of RPN calculator
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class RPNCalculator implements ICalculator {

    // stkNum is used to store numbers in RPN strings
    private Stack<Double> stkNum = new Stack<Double>();
    // stkLog is used to record the historical data in the stkNum
    private Stack<List<Double>> stkLog = new Stack<>();

    /**
     * Receives the RPN expression from the client and returns the calculation result
     *
     * @param rpn RPN expression
     * @return calculation results of RPN expression
     */
    @Override
    public String calcultor(String rpn) {

        rpn = rpn.trim().replaceAll("\\s{1,}", " ");
        String[] arpn = rpn.split(" ");
        int i = 0;
        int apLength = arpn.length;
        try {
            while (i < apLength) {
                if (strToDigit(arpn[i]) != null) {
                    stkNum.push(strToDigit(arpn[i]));
                    stkLog.push(StackUtils.getStack(stkNum));
                } else {
                    String opt = arpn[i];
                    IOptFactory optFactory = getOperation(opt);
                    boolean isSuccess = optFactory.createOperation().operate(stkNum, stkLog, opt, i);
                    if (!isSuccess) {
                        if (i + 1 < apLength) {
                            String remainder = rpn.substring(2 * i);
                            System.out.println("(The " + remainder + " were not pushed on to the stack due to the previous error)");
                        }
                        break;
                    }
                }
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return StackUtils.displayStack(stkNum);
    }

    /**
     * Select which operation object to create according to the operator type.
     *
     * @param opt string of the operator type
     * @return the instance of {@code IOptFactory}
     * @throws IllegalArgumentException
     *         if the {@code opt} is not the correct operator
     */
    public IOptFactory getOperation(String opt) throws Exception {

        switch (opt) {
            case "+":
            case "-":
            case "*":
            case "/":
                return new BaseOptFactory();
            case "sqrt":
                return new SqrtOptFactory();
            case "undo":
                return new UndoOptFactory();
            case "clear":
                return new ClearOptFactory();
            default:
                throw new IllegalArgumentException("Illegal RPN Operation: "+opt);
        }
    }

    /**
     * Converts a string to the numeric type double.
     * Conversion failure indicates that the string is not of numeric type and returns null.
     *
     * @param str string
     * @return the number of Double type or null
     */
    private Double strToDigit(String str) {
        try {
            double num = Double.valueOf(str);
            return num;
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
