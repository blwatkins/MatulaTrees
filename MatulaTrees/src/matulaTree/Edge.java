// Edge
// A single edge of a Matula Tree

package matulaTree;

public class Edge {
    private int parentPrimeFactor;
    private int childPrimeFactor;
    private Node child;

    public Edge(int parentPrimeFactor) {
        this.parentPrimeFactor = parentPrimeFactor;
        childPrimeFactor = 0;
        child = null;
    }

}
