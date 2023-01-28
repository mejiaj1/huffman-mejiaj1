package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileSaver implements Serializable {

    private String newCompressedText;
    private HuffmanTree newHuffmanTree;

    public String getNewCompressedText() {
        return newCompressedText;
    }

    public void setNewCompressedText(String newCompressedText) {
        this.newCompressedText = newCompressedText;
    }

    public HuffmanTree getNewHuffmanTree() {
        return newHuffmanTree;
    }

    public void setNewHuffmanTree(HuffmanTree newHuffmanTree) {
        this.newHuffmanTree = newHuffmanTree;
    }

    public static File saveHuffmanTree(HuffmanTree tree, String str) throws IOException {
        java.io.File file = new File(System.getProperty("user.home") + "/Desktop", "HuffmanTree.huff");
        FileOutputStream fileStream = new FileOutputStream(file);
        ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
        tree.buildTree(HuffmanAlgorithm.buildFrequencyTable(str));
        System.out.println(tree.head.getFrequency());
        objStream.writeObject(tree);
        objStream.close();
        fileStream.close();
        return file;
    }

    public static File saveHuffmanTree(HuffmanTree tree) throws IOException { //overloaded, call if tree is previously built
        java.io.File file = new File(System.getProperty("user.home") + "/Desktop", "HuffmanTree.huff");
        FileOutputStream fileStream = new FileOutputStream(file);
        ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
        System.out.println(tree.head.getFrequency());
        objStream.writeObject(tree);
        objStream.close();
        fileStream.close();
        return file;
    }

    public File saveCompressedText(String text) throws IOException {
        File file = new File(System.getProperty("user.home") + "/Desktop", "CompressedText.txt");
        Path path = Paths.get(file.getAbsolutePath());
        Files.write(path,HuffmanAlgorithm.encode(text).getBytes());
        return file;
    }

    public boolean loadHuffmanData(File compressedText, File huffmanTree) throws IOException, ClassNotFoundException {
        if(!compressedText.exists() || !huffmanTree.exists()) {
            return false;
        }
        else {
            newCompressedText = new String(Files.readAllBytes(compressedText.toPath()));


            FileInputStream huffmanTreeStream = new FileInputStream(huffmanTree);
            ObjectInputStream huffmanTreeObjStream = new ObjectInputStream(huffmanTreeStream);
            newHuffmanTree = (HuffmanTree) huffmanTreeObjStream.readObject();

            huffmanTreeObjStream.close();
            huffmanTreeStream.close();
            return true;
        }
    }

}
