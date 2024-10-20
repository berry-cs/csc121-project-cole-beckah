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
        
        c.fill(0,0,255);
        c.circle(200, 200, 5);
        
        this.n.draw(c);
        this.ss.draw(c);
        return c;
    }
	
    /** produce an updated state of this world after one time tick */
	public IWorld update() { 
		return new NemoWorld(this.s.move(), this.w, this.n.move(false, false, false, false), this.ss);
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
