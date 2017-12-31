package com.abisheknair.algorithms.implementations.union_find;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class QuickFind implements IUnionFind {

    private List<Integer> idConnectionList;

    QuickFind(int nodesCount) {
        
        this.idConnectionList = new ArrayList<>(nodesCount);

        for (int i = 0; i < nodesCount; i++) {
            this.idConnectionList.add(i, i);
        }
    }

    public void union(int node1Index, int node2Index) throws IndexOutOfBoundsException {

        if((node1Index >= this.idConnectionList.size()) || (node2Index >= this.idConnectionList.size())) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("Node id is greater than array size. N1: %d, N2: %d", node1Index, node2Index));
        }

        int node1Id = this.idConnectionList.get(node1Index);
        int node2Id = this.idConnectionList.get(node2Index);

        for (int nodeIter = 0; nodeIter < this.idConnectionList.size(); nodeIter++) {

            if(this.idConnectionList.get(nodeIter) == node1Id) {
                this.idConnectionList.set(nodeIter, node2Id);
            }
        }
    }

    public boolean isConnected(int node1Index, int node2Index) throws IndexOutOfBoundsException {

        if((node1Index >= this.idConnectionList.size()) || (node2Index >= this.idConnectionList.size())) {
            throw new IndexOutOfBoundsException(
                        String.format("Node id is greater than array size. N1: %d, N2: %d", node1Index, node2Index));
        }

        return (this.idConnectionList.get(node1Index).equals(this.idConnectionList.get(node2Index)));
    }

    public String serializeStructure() {

        StringJoiner strJoiner = new StringJoiner(",");

        for (int nodeIndex = 0; nodeIndex < this.idConnectionList.size(); nodeIndex++) {

            int nodeId = this.idConnectionList.get(nodeIndex);
            strJoiner.add(String.format("[%d]%d", nodeIndex, nodeId));
        }

        return strJoiner.toString();
    }
}
