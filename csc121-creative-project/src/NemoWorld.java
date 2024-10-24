import java.util.Objects;

import processing.core.*;
import processing.event.KeyEvent;

public class NemoWorld implements IWorld{
	ILoT<Shark> sharkList;
	ILoT<Wall> wallList;

	Nemo n;
	SeaShells ss;
	
	public NemoWorld(ILoT<Shark> sharkList, ILoT<Wall> wallList, Nemo n, SeaShells ss) {
		super();
		this.sharkList = sharkList;
		this.wallList = wallList;
		this.n = n;
		this.ss = ss;
	}

	/** produce an image of the state of this animation on given canvas */
    public PApplet draw(PApplet c) {
        c.background(135, 206, 250);  // clear the screen each time (color sky blue)
        this.sharkList.draw(c);
        this.wallList.draw(c);
        
        
        if (this.n.hitShark(sharkList)) {
            c.fill(255, 0, 0);
            c.circle(200, 200, 50);
        }
        
        
        this.n.draw(c); // draw nemo
        this.ss.draw(c); // draw seashells
        
        return c;
    }
	
    /** produce an updated state of this world after one time tick */
    public IWorld update() {
        ILoT<Shark> updatedSharkList = this.sharkList.update();  // Update the sharks
        return new NemoWorld(updatedSharkList, this.wallList, this.n, this.ss);
    }
	
	public IWorld keyPressed(KeyEvent kev) {
        boolean isUp = kev.getKeyCode() == PApplet.UP;
        boolean isDown = kev.getKeyCode() == PApplet.DOWN;
        boolean isLeft = kev.getKeyCode() == PApplet.LEFT;
        boolean isRight = kev.getKeyCode() == PApplet.RIGHT;

        Nemo updatedNemo = this.n.move(isUp, isDown, isLeft, isRight);
        return new NemoWorld(this.sharkList, this.wallList, updatedNemo, this.ss);
    }

	@Override
	public int hashCode() {
		return Objects.hash(n, sharkList, ss, wallList);
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
		return Objects.equals(n, other.n) && Objects.equals(sharkList, other.sharkList) && Objects.equals(ss, other.ss)
				&& Objects.equals(wallList, other.wallList);
	}

	@Override
	public String toString() {
		return "NemoWorld [sharkList=" + sharkList + ", wallList=" + wallList + ", n=" + n + ", ss=" + ss + "]";
	}	
}
