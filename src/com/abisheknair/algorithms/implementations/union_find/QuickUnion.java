package com.abisheknair.algorithms.implementations.union_find;

import java.util.StringJoiner;

public class QuickUnion implements IUnionFind {

    protected int[] idConnectionArray;

    public QuickUnion(int nodeCount) {

        this.idConnectionArray = new int[nodeCount];

        for (int nodeIndex = 0; nodeIndex < nodeCount; nodeIndex++) {
            this.idConnectionArray[nodeIndex] = nodeIndex;
        }
    }

    protected int getRoot(int nodeIndex) throws ArrayIndexOutOfBoundsException {

        if(nodeIndex >= idConnectionArray.length) {
            throw new ArrayIndexOutOfBoundsException(String.format("Node index is outside array limits. index: %d", nodeIndex));
        }

        while(nodeIndex != this.idConnectionArray[nodeIndex]) {
            nodeIndex = this.idConnectionArray[nodeIndex];
        }

        return nodeIndex;
    }

    @Override
    public void union(int node1Index, int node2Index) {

        int root1Index = getRoot(node1Index);
        int root2Index = getRoot(node2Index);

        this.idConnectionArray[root1Index] = root2Index;
    }

    @Override
    public boolean isConnected(int node1Index, int node2Index) {

        return (getRoot(node1Index) == getRoot(node2Index));
    }

    @Override
    public String serializeStructure() {

        StringJoiner strJoiner = new StringJoiner(",");

        for (int nodeIndex = 0; nodeIndex < this.idConnectionArray.length; nodeIndex++) {

            int nodeId = this.idConnectionArray[nodeIndex];
            strJoiner.add(String.format("[%d]%d", nodeIndex, nodeId));
        }

        return strJoiner.toString();
    }
}
