package com.abisheknair.algorithms.implementations;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImplementationTemplate implements IAlgorithmImplementation {

    private static Logger _logger;
    private final AlgorithmType _algorithmType;

    public ImplementationTemplate(AlgorithmType algorithmType) {
        _algorithmType = algorithmType;
    }

    public void start(Logger logger, Scanner inputDataScanner) {

       _logger = logger;

        try {

            beginAlgorithm();

        } catch (Exception excep) {
            _logger.log(Level.SEVERE, "Exception occurred", excep);
        }
    }

    private void beginAlgorithm() throws UnsupportedOperationException {

        throw new UnsupportedOperationException("Oops!");
    }
}
