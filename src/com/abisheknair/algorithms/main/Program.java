package com.abisheknair.algorithms.main;

import com.abisheknair.algorithms.utils.log.CustomLogFormatter;
import com.abisheknair.algorithms.implementations.IAlgorithmImplementation;
import com.abisheknair.algorithms.implementations.union_find.UnionFindImplementation;

import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.*;

public class Program {

    public static void main(String[] args) {

        // IAlgorithmImplementation algorithmImplementation = new ImplementationTemplate();
        IAlgorithmImplementation algorithmImplementation = new UnionFindImplementation();


        // Initialize helpers
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

        if(inputFileURL == null) {
            useStdin = true;
        } else {
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
        }

        if(useStdin) {
            logger.info("unable to read data from file. using Stdin");
            inputScanner = new Scanner(System.in);
        }

        return inputScanner;
    }
}
