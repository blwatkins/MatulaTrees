package matulaTree;

import java.util.ArrayList;

import numbers.Number;

public class Node {
    private Number number;
    private Node parent;
    private ArrayList<Edge> children;

    public Node(Number number) {
        this.number = number;
        parent = null;
        children = new ArrayList<>();
    }

}
