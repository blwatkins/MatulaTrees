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
        NumberStore.loadNumbers(this);
        NumberStore.output();
        System.out.println("-----------------------------");
        NumberStore.output();
        NumberStore.saveNumbers(this);
    }

    public void draw() {
        background(0);
    }

}
