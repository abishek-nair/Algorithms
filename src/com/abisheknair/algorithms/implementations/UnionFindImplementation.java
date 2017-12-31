package com.abisheknair.algorithms.implementations;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnionFindImplementation implements IAlgorithmImplementation {

    private static Logger _logger;

    private List<Integer> idConnectionMap;

    public void start(Logger logger) {

        _logger = logger;

        try {

            beginAlgorithm();

        } catch (Exception excep) {
            _logger.log(Level.SEVERE, "Exception occurred", excep);
        }
    }

    private void beginAlgorithm() throws Exception {

        _logger.info("Oh no! Something seems to be wrong!");
        throw new ExecutionControl.NotImplementedException("Oops!");
    }
}
