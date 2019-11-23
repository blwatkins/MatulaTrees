// Screen
// Basic screen class

package screens;

import processing.core.PApplet;

public abstract class Screen {
    protected PApplet p;

    public Screen(PApplet p) {
        this.p = p;
    }

    public abstract void display();

    public abstract void keyPressed();

    public abstract void mousePressed();

}
