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

    public String toString() {
        String out = "NODE \n";
        out += "    value = " + number.getValue() + "\n";
        out += "    children = " + getChildrenString() + "\n";

        for (Edge e: children) {
            out += e.getChild().toString();
        }

        return out;
    }

    private void addChildren() {
        for (long factor: number.getPrimeFactors()) {
            children.add(new Edge(factor));
        }
    }

    private String getChildrenString() {
        String out  = "";

        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i).getChild();
            long value = child.getNumber().getValue();
            out += "value";

            if (i != children.size() - 1) {
                out += ", ";
            }

        }

        return  out;
    }

}
