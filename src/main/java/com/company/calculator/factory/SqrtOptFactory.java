package com.company.calculator.factory;

import com.company.calculator.operation.IOperation;
import com.company.calculator.operation.SqrtOperation;

/**
 * The sqrt operation factory class, to create a instance of {@code SqrtOperation}
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class SqrtOptFactory implements IOptFactory {
    @Override
    public IOperation createOperation() {
        return new SqrtOperation();
    }
}
