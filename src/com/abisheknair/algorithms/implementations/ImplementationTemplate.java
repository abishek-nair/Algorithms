package com.abisheknair.algorithms.implementations;

import jdk.jshell.spi.ExecutionControl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImplementationTemplate implements IAlgorithmImplementation {

    private static Logger _logger;

    public void start(Logger logger) {

       _logger = logger;

        try {

            beginAlgorithm();

        } catch (Exception excep) {
            _logger.log(Level.SEVERE, "Exception occurred", excep);
        }
    }

    private void beginAlgorithm() throws Exception {

        throw new ExecutionControl.NotImplementedException("Oops!");
    }
}
