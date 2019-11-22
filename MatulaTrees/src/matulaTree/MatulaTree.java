// MatulaTree
// A Matula Tree class

package matulaTree;

import numbers.Number;
import numbers.NumberStore;

public class MatulaTree {
    private Node root;
    private int order;

    public MatulaTree(long value) {
        createTree(value);
    }

    public String toString() {
        String out = "MATULA TREE \n";
        out += root.toString();
        return out;
    }

    private void createTree(long value) {
        createRoot(value);
    }

    private void createRoot(long value) {
        Number number = NumberStore.getNumber(value);
        root = new Node(number);
    }

    private void buildTree() {
        buildTree(root);
    }

    private void buildTree(Node current) {
        for (Edge edge : current.getChildren()) {
            createChildNode(current, edge);
        }
    }

    private void createChildNode(Node parent, Edge edge) {
        long parentPrimeFactor = edge.getParentPrimeFactor();
        long parentValue = parent.getNumber().getValue();
        long prime_index = parentValue / parentPrimeFactor;
        //ong prime = NumberStore.getNthPrimeNumber(prime_index);
    }

}
