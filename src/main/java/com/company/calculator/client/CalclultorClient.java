package com.company.calculator.client;

import com.company.calculator.calculator.RPNCalculator;
import java.util.Scanner;

/**
 * The calculator client
 * Users input their RPN expressions by console and get the results
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class CalclultorClient {

    public static void main(String[] args) {
        RPNCalculator cf = new RPNCalculator();
        try {
            while (true) {
                System.out.println("Please input your RPN expression ：");
                Scanner scan = new Scanner(System.in);
                String rpn = scan.nextLine();
                String s = cf.calcultor(rpn);
                System.out.println("stack: "+s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
