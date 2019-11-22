// Edge
// A single edge of a Matula Tree

package matulaTree;

public class Edge {
    private long parentPrimeFactor;
    private long childPrimeFactor;
    private Node child;

    public Edge(long parentPrimeFactor) {
        this.parentPrimeFactor = parentPrimeFactor;
        childPrimeFactor = 0;
        child = null;
    }

}
