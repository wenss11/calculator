package com.company.calculator.factory;

import com.company.calculator.operation.BaseOperation;
import com.company.calculator.operation.IOperation;

/**
 * The basic operation factory class, to create a instance of {@code BaseOperation}
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class BaseOptFactory implements IOptFactory {
    @Override
    public IOperation createOperation() {
        return new BaseOperation();
    }
}
