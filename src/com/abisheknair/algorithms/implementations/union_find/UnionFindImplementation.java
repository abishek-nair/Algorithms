package com.abisheknair.algorithms.implementations.union_find;

import com.abisheknair.algorithms.implementations.IAlgorithmImplementation;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class UnionFindImplementation implements IAlgorithmImplementation {

    private static Logger _logger;

    public void start(Logger logger, Scanner inputDataScanner) {

        _logger = logger;

        try {

            beginAlgorithm(inputDataScanner);

        } catch (Exception excep) {
            _logger.log(Level.SEVERE, "Exception occurred", excep);
        }
    }

    private void beginAlgorithm(Scanner inputScanner) throws Exception {

        int nodeCount = inputScanner.nextInt();

        QuickUnionFind unionFind = new QuickUnionFind(nodeCount);

        while(inputScanner.hasNextInt()) {

            int node1Index = inputScanner.nextInt();
            int node2Index = inputScanner.nextInt();

            if(!unionFind.isConnected(node1Index, node2Index)) {
                _logger.info(String.format("Performing union(%d, %d)", node1Index, node2Index));
                unionFind.union(node1Index, node2Index);
                _logger.info(unionFind.serializeStructure());
            }
        }
    }
}
