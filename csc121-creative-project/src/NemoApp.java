// Cole and Beckah CSC 121

import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class NemoApp extends PApplet {	// <----- 1. rename AppTemplate everywhere in this file
    IWorld w;
    
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
        w = new NemoWorld(
        		new Shark(new Posn(200, 200), new Posn(-2, 0), new Posn(200, 400), 5, 10),
        		new Wall(new Posn(100, 100), 50, 10), new Nemo(new Posn(300, 300), 20, 20, 5, 0, 400, 0, 400), 
        		new SeaShells(new Posn(150, 150), 10, 0, 400, 0, 400));
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);
    }
    
    @Override
    public void mousePressed(MouseEvent mev) {
        w = w.mousePressed(mev);
    }
    
    @Override
   public void mouseReleased(MouseEvent mev) {
    	w = w.mouseReleased(mev);
    }

    @Override
   public void mouseMoved(MouseEvent mev) {
    	w = w.mouseMoved(mev);
    }
    
    @Override
    public void mouseDragged(MouseEvent mev) {
    	w = w.mouseDragged(mev);
    }
    
    @Override
    public void mouseClicked(MouseEvent mev) {
    	w = w.mouseClicked(mev);
    }

    @Override
    public void mouseEntered(MouseEvent mev) {
    	w = w.mouseEntered(mev);
    }

    @Override
    public void mouseExited(MouseEvent mev) {
    	w = w.mouseExited(mev);
    }
    
    @Override
    public void mouseWheel(MouseEvent mev) {
    	w = w.mouseWheel(mev);
    }

    @Override
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }

    @Override
    public void keyReleased(KeyEvent kev) {
        w = w.keyReleased(kev);
    }
    
    @Override
    public void keyTyped(KeyEvent kev) {
        w = w.keyTyped(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { NemoApp.class.getName() }, new NemoApp());
    }
}
