import processing.core.*;
import java.util.Objects;

public class Nemo {
	Posn loc;
	int width;
	int height;
	int playerSpeed;
	int topBound;
	int bottomBound;
	int leftBound;
	int rightBound;

	public Nemo(Posn loc, int width, int height, int playerSpeed, 
	            int topBound, int bottomBound, int leftBound, int rightBound) {
		super();
		this.loc = loc;
		this.width = width;
		this.height = height;
		this.playerSpeed = playerSpeed;
		this.topBound = topBound;
		this.bottomBound = bottomBound;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
	}

	public double getTop() {
		return this.loc.getY();
	}

	public double getBottom() {
		return this.loc.getY() + this.height;
	}

	public double getLeft() {
		return this.loc.getX();
	}

   
    
	public double getRight() {
		return this.loc.getX() + this.width;
	}

	public Nemo move(boolean isMovingUp, boolean isMovingDown, boolean isMovingLeft, boolean isMovingRight) {
		Posn newLoc = this.loc;
		if (isMovingUp && loc.getY() > topBound) {
			newLoc = newLoc.translate(new Posn(0, -playerSpeed));
		}
		if (isMovingDown && loc.getY() + height < bottomBound) {
			newLoc = newLoc.translate(new Posn(0, playerSpeed));
		}
		if (isMovingLeft && loc.getX() > leftBound) {
			newLoc = newLoc.translate(new Posn(-playerSpeed, 0));
		}
		if (isMovingRight && loc.getX() + width < rightBound) {
			newLoc = newLoc.translate(new Posn(playerSpeed, 0));
		}
		return new Nemo(newLoc, this.width, this.height, this.playerSpeed, this.topBound, this.bottomBound, this.leftBound, this.rightBound);
	}

	public PApplet draw(PApplet c) {
		c.noStroke();
		c.fill(255, 165, 0);  // Orange color for Nemo
		c.rect((int)this.loc.getX(), (int)this.loc.getY(), width, height);
		return c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loc, width, height, playerSpeed, topBound, bottomBound, leftBound, rightBound);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nemo other = (Nemo) obj;
		return width == other.width && height == other.height && playerSpeed == other.playerSpeed
				&& topBound == other.topBound && bottomBound == other.bottomBound
				&& leftBound == other.leftBound && rightBound == other.rightBound
				&& Objects.equals(loc, other.loc);
	}

	@Override
	public String toString() {
		return "Nemo [loc=" + loc + ", width=" + width + ", height=" + height 
				+ ", playerSpeed=" + playerSpeed + ", topBound=" + topBound 
				+ ", bottomBound=" + bottomBound + ", leftBound=" + leftBound 
				+ ", rightBound=" + rightBound + "]";
	}
}
