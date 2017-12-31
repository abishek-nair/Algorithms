package com.abisheknair.algorithms.implementations.union_find;

public class PathCompressedWeightedQuickUnion extends  WeightedQuickUnion {

    PathCompressedWeightedQuickUnion(int nodeCount) {

        super(nodeCount);
    }

    @Override
    public int getRoot(int nodeIndex) {

        if(nodeIndex >= super.idConnectionArray.length) {
            throw new ArrayIndexOutOfBoundsException(String.format("Node index is outside array limits. index: %d", nodeIndex));
        }

        while(nodeIndex != super.idConnectionArray[nodeIndex]) {

            super.idConnectionArray[nodeIndex] =
                    super.idConnectionArray[super.idConnectionArray[nodeIndex]];

            nodeIndex = super.idConnectionArray[nodeIndex];
        }

        return nodeIndex;
    }
}
