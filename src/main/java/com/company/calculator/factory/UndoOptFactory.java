package com.company.calculator.factory;

import com.company.calculator.operation.IOperation;
import com.company.calculator.operation.UndoOperation;

/**
 * The undo operation factory class, to create a instance of {@code UndoOperation}
 *
 * @author  wenss
 * @version V1.0
 * @since   JDK1.8
 */
public class UndoOptFactory implements IOptFactory {
    @Override
    public IOperation createOperation() {
        return new UndoOperation();
    }
}
