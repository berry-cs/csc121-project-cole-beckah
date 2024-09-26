import java.util.Objects;

import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class NemoWorld implements IWorld{
	Shark s;
	Wall w;
	Nemo n;
	SeaShells ss;
	
	
	public NemoWorld(Shark s, Wall w, Nemo n, SeaShells ss) {
		super();
		this.s = s;
		this.w = w;
		this.n = n;
		this.ss = ss;
	}
	
	
	/** produce an image of the state of this animation on given canvas */
    public PApplet draw(PApplet c) {
        c.background(135, 206, 250);  // clear the screen each time (color sky blue)
        this.s.draw(c);
        this.w.draw(c);
        this.n.draw(c);
        this.ss.draw(c);
        return c;
    }
	
	
	
	
	
}
