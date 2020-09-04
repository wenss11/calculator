package com.company.calculator.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class define some common method of stack
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class StackUtils {


    /**
     * Get the data in the {@code stk} and store it in the list collection
     *
     * @param stk initial stack
     * @return a list stored all the {@code stk} data
     */

    public static List<Double> getStack(Stack<Double> stk) {
        List<Double> getStk = new ArrayList<>();
        for (Double x : stk) {
            getStk.add(x);
        }
        return getStk;
    }

    /**
     * Display the data in the {@code stk} from bottom
     *
     * @param stk initial stack
     * @return a string contains all the {@code stk} data, split by ' '
     */
    public static String displayStack(Stack<Double> stk) {
        StringBuilder builder = new StringBuilder();
        if (stk.size() != 0) {
            for (Double x : stk) {
                builder.append(outputFormat(x));
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }

    /**
     * Define the display format of double type
     *
     * @param value initial double value
     * @return a string converted according to the specified format
     */
    public static String outputFormat(double value) {
        BigDecimal decimal = new BigDecimal(value).setScale(10,BigDecimal.ROUND_DOWN);
        DecimalFormat numformat = new DecimalFormat("#.##########");
        String output = numformat.format(decimal);
        return output;
    }

}