import numbers.Number;
import processing.core.PApplet;

import numbers.NumberStore;

public class MatulaTrees extends PApplet {

    public static void main(String[] args) {
        String[] processingArgs = {"MatulaTrees"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(1000, 1000);
    }

    public void setup() {
        NumberStore.loadNumbers(this);
        NumberStore.output();
        System.out.println("-----------------------------");
        NumberStore.addNumber(2);
        NumberStore.addNumber(3);
        NumberStore.addNumber(4);
        NumberStore.addNumber(5);
        NumberStore.addNumber(6);
        NumberStore.addNumber(7);
        NumberStore.addNumber(8);
        NumberStore.addNumber(9);
        NumberStore.addNumber(10);
        NumberStore.output();
        NumberStore.saveNumbers(this);
    }

    public void draw() {
        background(0);
    }

}
