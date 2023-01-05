package org.example;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanAlgorithm {

    public PriorityQueue<Node> buildFrequencyTable(String text){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new NodeComparator());
        HashMap<Character,Integer> freqTable = new HashMap<>();
        for (int i = 0; i < text.length(); i++){
            char character = text.charAt(i);
            if (!freqTable.containsKey(character)){
                freqTable.put(character,1);
            }
            else {
                freqTable.put(character,freqTable.get(character)+1);
            }

        }

        for (HashMap.Entry<Character, Integer> map : freqTable.entrySet()) {
            Node newNode = new Node(map.getValue(), map.getKey());
            priorityQueue.add(newNode);
        }

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }

        return priorityQueue;


        
    }

    public static void encode(String text) {

    }

    public static void decode(HuffmanTree tree, String text) {

    }
}
