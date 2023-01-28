package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HuffmanAlgorithm huffman = new HuffmanAlgorithm();
        HuffmanTree tree = new HuffmanTree();
        File compressedTextFile = new File(System.getProperty("user.home") + "/Desktop", "CompressedText.txt");
        File treeFile = new File(System.getProperty("user.home") + "/Desktop", "HuffmanTree.huff");
        FileSaver fileSaver = new FileSaver();
        fileSaver.loadHuffmanData(compressedTextFile,treeFile);
        HuffmanTree tree2 = fileSaver.getNewHuffmanTree();
        System.out.println(fileSaver.getNewCompressedText());
    }
}