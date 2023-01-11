package org.example;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.getFrequency().compareTo(o2.getFrequency());
    }


}
