// MatulaTree
// A Matula Tree class

package matulaTree;

import numbers.Number;
import numbers.NumberStore;

public class MatulaTree {
    private Node root;
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
        root.addChildrenFromFactors();
    }

    private void buildTree() {
        buildTree(root);
    }

    private void buildTree(Node current) {
        for (Edge edge : current.getChildren()) {
            buildChild(current, edge);
        }
    }

    private void buildChild(Node parent, Edge edge) {
        long parentPrimeFactor = edge.getParentPrimeFactor();
        long parentValue = parent.getNumber().getValue();
        long prime_index = parentValue / parentPrimeFactor;
        long prime = NumberStore.getNthPrimeNumber(prime_index);
        long parentPrimeFactorIndex = NumberStore.getNumber(parentPrimeFactor).getPrimeIndex();
        long childValue = prime * parentPrimeFactorIndex;

        if (prime != -1) {
            Node child = createChildNode(parent, childValue);
            edge.setChild(child);

            if (parentPrimeFactorIndex != 1) {
                addChildren(child, prime);
            }

            if (parentPrimeFactor != 2) {
                buildTree(child);
            }
        }

    }

    private Node createChildNode(Node parent, long value) {
        Number number = NumberStore.getNumber(value);
        Node child = new Node(number);
        child.setParent(parent);
        return child;
    }

    private void addChildren(Node child, long prime) {
        boolean currentChildPrimeFound = false;

        for (long factor: child.getNumber().getPrimeFactors()) {
            if (factor == prime && !currentChildPrimeFound) {
                currentChildPrimeFound = true;
                continue;
            }

            child.addChild(new Edge(factor));
        }
    }

}
