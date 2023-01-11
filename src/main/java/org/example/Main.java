package org.example;

public class Main {
    public static void main(String[] args) {
        HuffmanAlgorithm huffman = new HuffmanAlgorithm();
        HuffmanTree tree = new HuffmanTree();
        tree.buildTree(huffman.buildFrequencyTable("Jesse."));
    }
}