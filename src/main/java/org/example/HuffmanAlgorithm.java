package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanAlgorithm {

    public static PriorityQueue<Node> buildFrequencyTable(String text){
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

        return priorityQueue;


        
    }

    public static String encode(String text) throws IOException { //question for friday, caught in a loop becuase not all nodes are being hit, once e is found to have no children, it breaks
        PriorityQueue<Node> frequencyTable = buildFrequencyTable(text);
        HuffmanTree huffmanTree = new HuffmanTree();
        Node currentNode = huffmanTree.buildTree(frequencyTable).getHead();
        FileSaver.saveHuffmanTree(huffmanTree,text);
        HashMap<Character,String> binaryMap = createMap(currentNode,"");

        String compressedText = "";
        for (int i = 0; i < text.length(); i++){
            compressedText+= binaryMap.get(text.charAt(i));
        }
        System.out.println("Saved: " + calculateSpaceSaved(text, compressedText));
        return compressedText;


    }
    static HashMap<Character,String> binaryMap = new HashMap<>();
    public static HashMap<Character,String> createMap(Node node, String binary){
        Node currentNode = node;

            if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null){ //no children
                binaryMap.put(currentNode.getCharacter(), binary);
                return binaryMap;
            }
        binaryMap.putAll(createMap(node.getLeftChild(), binary + "0"));
        binaryMap.putAll(createMap(node.getRightChild(), binary + "1"));
            return binaryMap;
        }

    public static String decode(HuffmanTree tree, String text) {
        if (!isBinary(text)){
            return "ERROR: Not binary";
        }
        else {
            String returnString = "";
            Node currentNode = tree.getHead();
            for (int i = 0; i < text.length();i++){
                if (text.charAt(i) == '0'){
                    currentNode = currentNode.getLeftChild();
                }
                if (text.charAt(i) == '1'){
                    currentNode = currentNode.getRightChild();
                }
                if (currentNode.getRightChild() == null && currentNode.getLeftChild() == null){
                    returnString += currentNode.getCharacter();
                    currentNode = tree.getHead();
                }
            }
            return returnString;
        }

    }

    public static boolean isBinary(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '0' && string.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }
    public static double calculateSpaceSaved(String original, String compressed) {
        return 1.0 - (compressed.length() / (double) (original.length() * 8));
    }

}
