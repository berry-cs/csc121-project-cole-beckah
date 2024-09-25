import java.util.Objects;

import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class NemoWorld implements IWorld{
	Shark s;
	Wall w;
	
	
	public NemoWorld(Shark s, Wall w) {
		super();
		this.s = s;
		this.w = w;
	}
	
	
	/** produce an image of the state of this animation on given canvas */
    public PApplet draw(PApplet c) {
        c.background(135, 206, 250);  // clear the screen each time (color sky blue)
        this.s.draw(c);
        this.w.draw(c);
        return c;
    }
	
	
	
	
	
}
