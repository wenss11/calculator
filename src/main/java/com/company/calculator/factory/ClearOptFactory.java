package com.company.calculator.factory;

import com.company.calculator.operation.ClearOperation;
import com.company.calculator.operation.IOperation;

/**
 * The clear operation factory class, to create a instance of {@code ClearOperation}
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class ClearOptFactory implements IOptFactory {
    @Override
    public IOperation createOperation() {
        return new ClearOperation();
    }
}
