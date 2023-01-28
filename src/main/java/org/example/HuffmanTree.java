package org.example;

import java.io.Serializable;
import java.util.PriorityQueue;

public class HuffmanTree implements Serializable {

    Node head;
    public Node getHead(){
        return head;
    }

    public void setHead(Node headAdded){
        head = headAdded;
    }

    public HuffmanTree buildTree(PriorityQueue<Node> freqTable){ //prints as null second time around, is this a problem?
        while (!(freqTable.size() <= 1)){
            System.out.println("--------------------------------------");
            Node left = freqTable.poll();
            Node right = freqTable.poll();
            Node newNode = new Node(left, right);
            System.out.println("Merging Node A (char - " + left.getCharacter()+", freq - "+left.getFrequency()+")");
            System.out.println("With Node B (char - " + right.getCharacter()+", freq - "+right.getFrequency()+")");
            System.out.println("New mini tree built. Parent node has frequency of "+newNode.getFrequency()+". Left child is: "+left.getCharacter()+", freq "+left.getFrequency()+". Right child is "+right.getCharacter()+", freq "+right.getFrequency()+".");
            freqTable.add(newNode);
            System.out.println("Elements remaining in PQ: " + freqTable.size());
            System.out.println("");
            if(freqTable.size()==1)
                break;
        }
        setHead(freqTable.poll());
        return this;
    }

    }

