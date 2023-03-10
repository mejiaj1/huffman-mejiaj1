package org.example;

import java.io.Serializable;

public class Node implements Serializable {
    private Integer frequency;
    private Character character;
    private Node leftChild;
    private Node rightChild;

    private String binaryCode = "";

    public String getBinaryCode() {
        return binaryCode;
    }

    public void setBinaryCode(String binaryCode) {
        this.binaryCode = binaryCode;
    }

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        frequency = leftChild.getFrequency() + rightChild.getFrequency();
    }

    public Node(Integer frequency, Character val) {
        this.frequency = frequency;
        this.character = val;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public String toString() {
        return frequency + ", " + character;
    }

}
