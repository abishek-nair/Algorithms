package com.abisheknair.algorithms.main;

import com.abisheknair.algorithms.implementations.AlgorithmImplementationFactory;
import com.abisheknair.algorithms.implementations.AlgorithmType;
import com.abisheknair.algorithms.utils.log.CustomLogFormatter;
import com.abisheknair.algorithms.implementations.IAlgorithmImplementation;
import com.abisheknair.algorithms.implementations.union_find.UnionFindImplementation;

import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.*;

public class Program {

    public static void main(String[] args) {

        IAlgorithmImplementation algorithmImplementation;

        // algorithmImplementation = new ImplementationTemplate();
        // algorithmImplementation = AlgorithmImplementationFactory.getImplementation(AlgorithmType.QUICK_FIND);
        algorithmImplementation = AlgorithmImplementationFactory.getImplementation(AlgorithmType.QUICK_UNION);


        // Initialize dependencies
        Logger logger = getLoggerInstance(algorithmImplementation.getClass().getName());
        Scanner inputScanner = getInputDataScanner(algorithmImplementation, logger);
        // Execute the algorithm
        algorithmImplementation.start(logger, inputScanner);
    }

    private static Logger getLoggerInstance(String className) {

        Logger logger = Logger.getLogger(className);
        logger.setUseParentHandlers(false);

        ConsoleHandler consoleLogHandler = new ConsoleHandler();
        consoleLogHandler.setFormatter(new CustomLogFormatter());

        logger.addHandler(consoleLogHandler);

        return logger;
    }

    private static Scanner getInputDataScanner(IAlgorithmImplementation algoImplementation, Logger logger) {

        Scanner inputScanner = null;
        boolean useStdin = false;

        String className = algoImplementation.getClass().getSimpleName().toLowerCase();
        String inputFilePath = String.format("input_files/%s/input.txt", className);
        URL inputFileURL = algoImplementation.getClass().getClassLoader().getResource(inputFilePath);

        if(inputFileURL != null) {

            try {

                File inputFile = new File(inputFileURL.toURI());

                if(inputFile.exists()) {
                    logger.info(String.format("fetching input data from file: %s", inputFile.getAbsolutePath()));
                    inputScanner = new Scanner(inputFile);
                } else {
                    useStdin = true;
                }
            } catch (Exception excep) {
                useStdin = true;
            }
        } else {

            useStdin = true;
        }

        if(useStdin) {
            logger.info("unable to read data from file. using Stdin");
            inputScanner = new Scanner(System.in);
        }

        return inputScanner;
    }
}
