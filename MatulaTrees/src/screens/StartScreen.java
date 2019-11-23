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
        p.fill(255);
        p.textAlign(p.CENTER, p.CENTER);
        p.textSize(40);
        p.text("Matula Trees", p.width / 2f, p.height / 2f);
    }

    public void keyPressed() {

    }

    public void mousePressed() {

    }

}
