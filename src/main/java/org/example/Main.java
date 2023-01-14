package org.example;

public class Main {
    public static void main(String[] args) {
        HuffmanAlgorithm huffman = new HuffmanAlgorithm();
        System.out.println(huffman.isBinary(huffman.encode("data structures")));
        System.out.println(huffman.isBinary("00001000"));
    }
}