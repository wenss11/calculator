package com.company.calculator.factory;

import com.company.calculator.operation.IOperation;

/**
 * The factory interface of operation
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public interface IOptFactory {
    public IOperation createOperation();
}
