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
        
        c.fill(0,0,255);
        c.circle(200, 200, 5);
        
        return c;
    }
	
    /** produce an updated state of this world after one time tick */
	public IWorld update() { 
		return new NemoWorld( this.s.move(), this.w );
	}


	@Override
	public int hashCode() {
		return Objects.hash(s, w);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NemoWorld other = (NemoWorld) obj;
		return Objects.equals(s, other.s) && Objects.equals(w, other.w);
	}


	@Override
	public String toString() {
		return "NemoWorld [s=" + s + ", w=" + w + "]";
	}

	
	
	
}
