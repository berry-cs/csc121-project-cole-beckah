import java.util.Objects;

import processing.core.PApplet;

public class Wall extends PApplet {
	Posn loc;
	int w;
	int h;
	int color;
	double top;
	double bottom;
	double left;
	double right;

	public Wall(Posn loc, int w, int h, int color, double top, double bottom, double left, double right) {
		super();
		this.loc = loc;
		this.w = w;
		this.h = h;
		this.color = color(27, 203, 28);
		this.top = this.loc.getY();
		this.bottom = this.loc.getY() + this.h;
		this.left = this.loc.getX();
		this.right = this.loc.getX() + this.w;
	}

	public PApplet draw(PApplet c) {
        c.noStroke();  // no outline
        c.fill(color); // (R, G, B) = "red"
        c.rect((float)this.loc.getX(), (float)this.loc.getY(), this.w, this.h);
        return c;
    }

	@Override
	public int hashCode() {
		return Objects.hash(bottom, color, h, left, loc, right, top, w);
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
		return Double.doubleToLongBits(bottom) == Double.doubleToLongBits(other.bottom) && color == other.color
				&& h == other.h && Double.doubleToLongBits(left) == Double.doubleToLongBits(other.left)
				&& Objects.equals(loc, other.loc)
				&& Double.doubleToLongBits(right) == Double.doubleToLongBits(other.right)
				&& Double.doubleToLongBits(top) == Double.doubleToLongBits(other.top) && w == other.w;
	}


	@Override
	public String toString() {
		return "Wall [loc=" + loc + ", w=" + w + ", h=" + h + ", color=" + color + ", top=" + top + ", bottom=" + bottom
				+ ", left=" + left + ", right=" + right + "]";
	}

}