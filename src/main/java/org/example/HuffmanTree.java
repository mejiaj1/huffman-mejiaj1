package org.example;

import java.util.PriorityQueue;

public class HuffmanTree {

    public PriorityQueue<Node> buildTree(PriorityQueue<Node> freqTable){
        while (!(freqTable.size() <= 1)){
            Node newNode = new Node(freqTable.poll(),freqTable.poll());
            freqTable.add(newNode);
        }
        System.out.println(".");
        return freqTable;
    }
}

