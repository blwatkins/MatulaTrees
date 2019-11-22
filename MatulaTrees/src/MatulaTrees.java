import matulaTree.MatulaTree;
import processing.core.PApplet;

import numbers.NumberStore;

public class MatulaTrees extends PApplet {

    public static void main(String[] args) {
        String[] processingArgs = {"MatulaTrees"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        MatulaTree m = new MatulaTree(2);
        System.out.println(m);
    }

    public void draw() {
        background(0);
    }

}
