import java.util.Objects;

import processing.core.*;

public class Shark extends PApplet{
	Posn loc;
	Posn speed;
	Posn spawnpoint;
	int h;
	int w;
	double top;
	double bottom;
	double left;
	double right;

	
	
	public Shark(Posn loc, Posn speed, Posn spawnpoint, int h, int w, double topBound, double bottomBound,
			double leftBound, double rightBound) {
		super();
		this.loc = loc;
		this.speed = speed;
		this.spawnpoint = spawnpoint;
		this.h = h;
		this.w = w;
		this.top = this.loc.getY();
		this.bottom = this.loc.getY() + this.h;
		this.left = this.loc.getX();
		this.right = this.loc.getX() + this.w;
	}

	public Shark respawn() {
	    if (this.loc.getX() < 0) {
	    	return new Shark(this.loc.translate(this.spawnpoint), this.speed, this.spawnpoint, this.h, this.w, this.top, this.bottom, this.left, this.right);
	    }
	    else {
	    	return this;
	    }
	  }

	public PApplet draw(PApplet c) {
		c.stroke(0);   // color black
		c.imageMode(PApplet.CENTER);
		c.image(c.loadImage("shark.gif"), (int)this.loc.getX(), (int)this.loc.getY());
		return c;
	}

	public Shark move() {
		return new Shark(this.loc.translate(this.speed), this.speed, this.spawnpoint, this.h, this.w, this.top, this.bottom, this.left, this.right);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bottom, h, left, loc, right, spawnpoint, speed, top, w);
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
		return Double.doubleToLongBits(bottom) == Double.doubleToLongBits(other.bottom) && h == other.h
				&& Double.doubleToLongBits(left) == Double.doubleToLongBits(other.left)
				&& Objects.equals(loc, other.loc)
				&& Double.doubleToLongBits(right) == Double.doubleToLongBits(other.right)
				&& Objects.equals(spawnpoint, other.spawnpoint) && Objects.equals(speed, other.speed)
				&& Double.doubleToLongBits(top) == Double.doubleToLongBits(other.top) && w == other.w;
	}


	@Override
	public String toString() {
		return "Shark [loc=" + loc + ", speed=" + speed + ", spawnpoint=" + spawnpoint + ", h=" + h + ", w=" + w
				+ ", top=" + top + ", bottom=" + bottom + ", left=" + left + ", right=" + right + "]";
	}
}
