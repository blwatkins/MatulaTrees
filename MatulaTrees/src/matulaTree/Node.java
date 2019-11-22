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
    }

    public ArrayList<Edge> getChildren() {
        return children;
    }

    public Number getNumber() {
        return number;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addChild(Edge e) {
        children.add(e);
    }

    public void addChildrenFromFactors() {
        for (long factor: number.getPrimeFactors()) {
            children.add(new Edge(factor));
        }
    }

    public String toString() {
        String out = "NODE \n";
        out += "    value = " + number.getValue() + "\n";
        out += "    children = " + getChildrenString() + "\n";

        for (Edge e: children) {
            if (e.getChild() != null) {
                out += e.getChild().toString();
            }
        }

        return out;
    }

    private String getChildrenString() {
        String out  = "[";

        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i).getChild();

            if (child != null) {
                long value = child.getNumber().getValue();
                out += value;

                if (i != children.size() - 1) {
                    out += ", ";
                }
            }

        }

        out += "]\n";
        return  out;
    }

}
