package com.abisheknair.algorithms.implementations;

import com.abisheknair.algorithms.implementations.union_find.UnionFindImplementation;

public class AlgorithmImplementationFactory {

    public static IAlgorithmImplementation getImplementation(AlgorithmType algorithmType)
            throws UnsupportedOperationException {

        IAlgorithmImplementation algorithmImplementation;

        switch (algorithmType) {

            case QUICK_FIND:
            case QUICK_UNION:
            case QUICK_UNION_BALANCED:
            case QUICK_UNION_BALANCED_PATH_COMPRESSED:
                algorithmImplementation = new UnionFindImplementation(algorithmType);
                break;

            default:
                throw new UnsupportedOperationException(
                        String.format("IAlgorithmImplementation not implemented for the type %s",
                                algorithmType.toString()));
        }

        return algorithmImplementation;
    }
}
