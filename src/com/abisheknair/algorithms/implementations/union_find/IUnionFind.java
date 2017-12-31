package com.abisheknair.algorithms.implementations.union_find;

public interface IUnionFind {

    void union(int node1Index, int node2Index);

    boolean isConnected(int node1Index, int node2Index);

    String serializeStructure();
}
