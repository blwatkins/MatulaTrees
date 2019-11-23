// StartScreen
// The screen that will be shown at the beginning of every program run

package screens;

import processing.core.PApplet;

public class StartScreen extends Screen {

    public StartScreen(PApplet p) {
        super(p);
    }

    public void display() {
        p.background(0);
        p.ellipse(p.mouseX, p.mouseY, 50, 50);
    }

    public void keyPressed() {

    }

    public void mousePressed() {
        p.fill(p.random(255));
    }

}
