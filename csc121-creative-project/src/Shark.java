import java.util.Objects;

import processing.core.*;

public class Shark {
	//loc is top-left corner
	Posn loc;
	Posn speed;
	Posn spawnpoint;
	int h;
	int w;
	
	/** can I do this?
	double top = loc.getY();
	double bottom = loc.getY() + this.h;
	double left = loc.getX();
	double right = loc.getX() + this.w;
	*/
	
	public Shark(Posn loc, Posn speed, Posn spawnpoint, int h, int w) {
		super();
		this.loc = loc;
		this.speed = speed;
		this.spawnpoint = spawnpoint;
		this.h = h;
		this.w = w;
	}

	public double getTop() {
		return this.loc.getY();
	}
	
	public double getBottom() {
		return this.loc.getY() + this.h;
	}
	
	public double getLeft() {
		return this.loc.getX();
	}
	
	public double getRight() {
		return this.loc.getX() + this.w;
	}

	public Shark respawn() {
	    if (this.loc.getX() < 0) {
	    	return new Shark(this.loc.translate(this.spawnpoint), this.speed, this.spawnpoint, this.h, this.w);
	    }
	    else {
	    	return this;
	    }
	  }

	public PApplet draw(PApplet c) {
		c.stroke(0);   // color black
		c.pushMatrix();
		
		c.translate((int)this.loc.getX(), (int)this.loc.getY());
		c.scale(.15f);
		if (this.speed.getX() > 0) {
			c.scale(-1, 1);
		}
		
		c.imageMode(PApplet.CENTER);
		c.image(c.loadImage("shark.png"), 0, 0);
		
		c.popMatrix();
		return c;
	}

	public Shark move() {
		return new Shark(this.loc.translate(this.speed), this.speed, this.spawnpoint, this.h, this.w);
	}

	@Override
	public int hashCode() {
		return Objects.hash(h, loc, spawnpoint, speed, w);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shark other = (Shark) obj;
		return h == other.h && Objects.equals(loc, other.loc) && Objects.equals(spawnpoint, other.spawnpoint)
				&& Objects.equals(speed, other.speed) && w == other.w;
	}

	@Override
	public String toString() {
		return "Shark [loc=" + loc + ", speed=" + speed + ", spawnpoint=" + spawnpoint + ", h=" + h + ", w=" + w + "]";
	}

}