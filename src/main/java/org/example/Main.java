package org.example;

public class Main {
    public static void main(String[] args) {
        HuffmanAlgorithm huffman = new HuffmanAlgorithm();
        HuffmanTree tree = new HuffmanTree();
        System.out.println(huffman.decode(tree.buildTree(huffman.buildFrequencyTable("The quick brown fox jumps over the lazy dog 1234567890")),huffman.encode("The quick brown fox jumps over the lazy dog 1234567890")));
    }
}