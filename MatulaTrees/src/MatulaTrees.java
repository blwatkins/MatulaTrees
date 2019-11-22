import processing.core.PApplet;

import numbers.NumberStore;
import matulaTree.MatulaTree;

public class MatulaTrees extends PApplet {

    public static void main(String[] args) {
        String[] processingArgs = {"MatulaTrees"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        NumberStore.loadNumbers(this);
        NumberStore.loadNthPrimes(this);
        MatulaTree m = new MatulaTree(199);
        System.out.println(m);
        NumberStore.saveNumbers(this);
        NumberStore.saveNthPrimes(this);
    }

    public void draw() {
        background(0);
    }

}
