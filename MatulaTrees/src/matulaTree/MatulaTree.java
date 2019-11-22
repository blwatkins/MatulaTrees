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

    private void createTree(long value) {
        createRoot(value);
    }

    private void createRoot(long value) {
        Number number = NumberStore.getNumber(value);
        root = new Node(number);
    }

}
