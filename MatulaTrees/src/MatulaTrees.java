import processing.core.PApplet;

import numbers.NumberStore;
import matulaTree.MatulaTree;
import screens.Screen;
import screens.StartScreen;

public class MatulaTrees extends PApplet {
    Screen screen;
    Screen startScreen;


    public static void main(String[] args) {
        String[] processingArgs = {"MatulaTrees"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
//        NumberStore.loadNumbers(this);
//        NumberStore.loadNthPrimes(this);
        MatulaTree m = new MatulaTree(1);
        System.out.println(m);
//        NumberStore.saveNumbers(this);
//        NumberStore.saveNthPrimes(this);

        startScreen = new StartScreen(this);
        screen = startScreen;
    }

    public void draw() {
        screen.display();
    }

    public void keyPressed() {
        screen.keyPressed();
    }

    public void mousePressed() {
        screen.mousePressed();
    }

}
