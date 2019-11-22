// Node
// A single node of the MatulaTree

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
        addChildren();
    }

    public ArrayList<Edge> getChildren() {
        return children;
    }

    public Number getNumber() {
        return number;
    }

    private void addChildren() {
        for (long factor: number.getPrimeFactors()) {
            children.add(new Edge(factor));
        }
    }

}
