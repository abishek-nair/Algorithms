package com.abisheknair.algorithms.main;

import com.abisheknair.algorithms.implementations.*;
import com.abisheknair.algorithms.utils.log.CustomLogFormatter;

import java.util.logging.*;

public class Program {

    public static void main(String[] args) {

        // IAlgorithmImplementation algorithmImplementation = new ImplementationTemplate();
        IAlgorithmImplementation algorithmImplementation = new UnionFindImplementation();


        // Initialize helpers
        Logger logger = getLoggerInstance(algorithmImplementation.getClass().getName());
        // Execute the algorithm
        algorithmImplementation.start(logger);
    }

    private static Logger getLoggerInstance(String className) {

        Logger logger = Logger.getLogger(className);
        logger.setUseParentHandlers(false);

        ConsoleHandler consoleLogHandler = new ConsoleHandler();
        consoleLogHandler.setFormatter(new CustomLogFormatter());

        logger.addHandler(consoleLogHandler);

        return logger;
    }
}
