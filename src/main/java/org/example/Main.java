package org.example;

public class Main {
    public static void main(String[] args) {
        HuffmanAlgorithm huffman = new HuffmanAlgorithm();
        huffman.buildFrequencyTable("It was her first experience training a rainbow unicorn.");
    }
}