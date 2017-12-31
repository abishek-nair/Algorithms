package com.abisheknair.algorithms.implementations.union_find;

import com.abisheknair.algorithms.implementations.AlgorithmType;
import com.abisheknair.algorithms.implementations.IAlgorithmImplementation;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class UnionFindImplementation implements IAlgorithmImplementation {

    private static Logger _logger;
    private final AlgorithmType _algorithmType;

    public UnionFindImplementation(AlgorithmType algorithmType) {
        _algorithmType = algorithmType;
    }

    public void start(Logger logger, Scanner inputDataScanner) {

        _logger = logger;

        try {

            beginAlgorithm(inputDataScanner);

        } catch (Exception excep) {
            _logger.log(Level.SEVERE, "Exception occurred", excep);
        }
    }

    private void beginAlgorithm(Scanner inputScanner) throws Exception {

        Instant algoStart = Instant.now();

        int nodeCount = inputScanner.nextInt();
        int nodeIndex = 1;

        IUnionFind unionFind = getUnionFindInstance(nodeCount);

        while(inputScanner.hasNextInt()) {

            int node1Index = inputScanner.nextInt();
            int node2Index = inputScanner.nextInt();

            if(!unionFind.isConnected(node1Index, node2Index)) {
                // _logger.info(String.format("Performing union(%d, %d)", node1Index, node2Index));
                unionFind.union(node1Index, node2Index);
                // _logger.info(unionFind.serializeStructure());
            }

            _logger.info(String.format("[%d / %d]", nodeIndex, 2 * nodeCount));
            nodeIndex ++;
        }

        Instant algoEnd = Instant.now();
        _logger.info(String.format("%s => Time elapsed: %s",
                                    this._algorithmType.toString(), Duration.between(algoEnd, algoStart).toString()));

        // runTests(unionFind);
    }

    private void runTests(IUnionFind unionFind) throws Exception {

        boolean isCorrect = true;

        isCorrect = isCorrect && (unionFind.isConnected(8,9) == true);
        isCorrect = isCorrect && (unionFind.isConnected(5,4) == false);

        if(!isCorrect) {
            throw new Exception("Union find test failed");
        }
    }

    private IUnionFind getUnionFindInstance(int nodeCount) throws UnsupportedOperationException {

        switch (this._algorithmType) {

            case QUICK_UNION:
                return new QuickUnion(nodeCount);

            case QUICK_FIND:
                return new QuickFind(nodeCount);

            case QUICK_UNION_BALANCED:
                return new WeightedQuickUnion(nodeCount);

            case QUICK_UNION_BALANCED_PATH_COMPRESSED:
                return new PathCompressedWeightedQuickUnion(nodeCount);

            default:
                throw new UnsupportedOperationException("This algorithm type is not supported");
        }
    }
}
