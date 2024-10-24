import java.util.Objects;

import processing.core.*;

import java.util.Random;

public class Shark implements GameObject<Shark> {
	//loc is top-left corner
	Posn loc;
	Posn speed;
	Posn spawnpoint;
	int h;
	int w;
	int screenWidth;
	int screenHeight;
	
	
	final static int SHARKHITRADIUS = 10;

	/** can I do this?
	double top = loc.getY();
	double bottom = loc.getY() + this.h;
	double left = loc.getX();
	double right = loc.getX() + this.w;
	 */

	public Shark(Posn loc, Posn speed, Posn spawnpoint, int h, int w, int screenWidth, int screenHeight) {
		super();
		this.loc = loc;
		this.speed = speed;
		this.spawnpoint = spawnpoint;
		this.h = h;
		this.w = w;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
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

	// Move the shark and respawn it when necessary
	public Shark update() {
        Posn newLoc = this.loc.translate(this.speed);

        if (newLoc.getX() > screenWidth) {
            Random rand = new Random();
            double randomY = rand.nextDouble() * (screenHeight - this.h);
            newLoc = new Posn(-this.w, randomY);
        }
        return new Shark(newLoc, this.speed, this.spawnpoint, this.h, this.w, this.screenWidth, this.screenHeight);
    }

	public void draw(PApplet c) {
		c.stroke(0);  // color black
		c.pushMatrix();
		c.translate((int) this.loc.getX(), (int) this.loc.getY());
		c.scale(0.15f);
		if (this.speed.getX() > 0) {
			c.scale(-1, 1);
		}

		c.imageMode(PApplet.CENTER);
		c.image(c.loadImage("shark.png"), 0, 0);

		c.popMatrix();
		
		c.fill(155);
		c.circle((int)loc.getX() + 30, (int)loc.getY(), SHARKHITRADIUS * 2);
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

	@Override
	public boolean checkHit(Posn ctr, int rad) {
		Posn sharkHitCtr = new Posn((int)loc.getX() + 30, (int)loc.getY());
		return sharkHitCtr.distanceTo(ctr) < (SHARKHITRADIUS + rad);
	}

}