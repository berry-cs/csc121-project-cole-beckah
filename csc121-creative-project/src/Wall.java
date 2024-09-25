import java.util.Objects;

import processing.core.PApplet;

public class Wall  {
	//loc is top-left corner
	Posn loc;
	int w;
	int h;

	public Wall(Posn loc, int w, int h) {
		super();
		this.loc = loc;
		this.w = w;
		this.h = h;
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

	public PApplet draw(PApplet c) {
        c.noStroke();  // no outline
        c.fill(c.color(27, 203, 28)); // (R, G, B) = "red"
        c.rect((float)this.loc.getX(), (float)this.loc.getY(), this.w, this.h);
        return c;
    }


	@Override
	public int hashCode() {
		return Objects.hash(h, loc, w);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wall other = (Wall) obj;
		return h == other.h && Objects.equals(loc, other.loc) && w == other.w;
	}

	@Override
	public String toString() {
		return "Wall [loc=" + loc + ", w=" + w + ", h=" + h + "]";
	}
}