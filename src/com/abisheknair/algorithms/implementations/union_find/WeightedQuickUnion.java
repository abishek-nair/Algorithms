package com.abisheknair.algorithms.implementations.union_find;

import java.util.Arrays;

public class WeightedQuickUnion extends QuickUnion {

    private int[] treeSizeArray;

    public WeightedQuickUnion(int nodeCount) {

        super(nodeCount);

        treeSizeArray = new int[nodeCount];
        Arrays.fill(treeSizeArray, 1);
    }

    @Override
    public void union(int node1Index, int node2Index) {

        int root1Index = super.getRoot(node1Index);
        int root2Index = super.getRoot(node2Index);

        if(root1Index == root2Index) {
            return;
        }

        if(treeSizeArray[root1Index] < treeSizeArray[root2Index]) {

            super.idConnectionArray[root1Index] = root2Index;
            treeSizeArray[root2Index] += treeSizeArray[root1Index];
        } else {

            super.idConnectionArray[root2Index] = root1Index;
            treeSizeArray[root1Index] += treeSizeArray[root2Index];
        }
    }
}
