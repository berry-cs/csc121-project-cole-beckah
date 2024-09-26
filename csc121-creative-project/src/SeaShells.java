import java.util.Objects;

import processing.core.*;

public class SeaShells {
	Posn loc;
	int radius;
	int topBound;
	int bottomBound;
	int leftBound;
	int rightBound;

	public SeaShells(Posn loc, int radius, int topBound, int bottomBound, int leftBound, int rightBound) {
		super();
		this.loc = loc;
		this.radius = radius;
		this.topBound = topBound;
		this.bottomBound = bottomBound;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
	}

	public double getTop() {
		return this.loc.getY() - this.radius;
	}

	public double getBottom() {
		return this.loc.getY() + this.radius;
	}

	public double getLeft() {
		return this.loc.getX() - this.radius;
	}

	public double getRight() {
		return this.loc.getX() + this.radius;
	}

	public PApplet draw(PApplet c) {
		c.noStroke();
		c.fill(0, 255, 127);  // Sea green color for SeaShells
		c.ellipse((int)this.loc.getX(), (int)this.loc.getY(), radius * 2, radius * 2);
		return c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loc, radius, topBound, bottomBound, leftBound, rightBound);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeaShells other = (SeaShells) obj;
		return radius == other.radius && topBound == other.topBound 
				&& bottomBound == other.bottomBound && leftBound == other.leftBound 
				&& rightBound == other.rightBound && Objects.equals(loc, other.loc);
	}

	@Override
	public String toString() {
		return "SeaShells [loc=" + loc + ", radius=" + radius + ", topBound=" + topBound 
				+ ", bottomBound=" + bottomBound + ", leftBound=" + leftBound 
				+ ", rightBound=" + rightBound + "]";
	}
}
