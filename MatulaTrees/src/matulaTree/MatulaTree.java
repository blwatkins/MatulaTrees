// MatulaTree
// A Matula Tree class

package matulaTree;

import numbers.Number;
import numbers.NumberStore;

public class MatulaTree {
    private Node root;
    private int order;
    private boolean building;

    public MatulaTree(long value) {
        building = true;
        createTree(value);
        building = false;
    }

    public String toString() {
        String out = "MATULA TREE \n";
        out += root.toString();
        return out;
    }

    private void createTree(long value) {
        createRoot(value);
        buildTree();
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
        long prime = NumberStore.getNthPrimeNumber(prime_index);

        if (prime != -1 ) {
            order++;
            long parentPrimeFactorIndex = NumberStore.getNumber(parentPrimeFactor).getPrimeIndex();
            long childValue = prime * parentPrimeFactorIndex;

            Number childNumber = NumberStore.getNumber(childValue);
            Node childNode = new Node(childNumber);
            childNode.setParent(parent);
            edge.setChild(childNode);
        }
    }

}
