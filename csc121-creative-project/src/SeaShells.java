
import java.util.Objects;

import processing.core.PApplet;

public class SeaShells extends PApplet {
    int x;
    int y;
    int radius;
    int topBound;
    int bottomBound;
    int leftBound;
    int rightBound;

    public SeaShells(int x, int y, int radius,
                     int topBound, int bottomBound, int leftBound, int rightBound) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.topBound = topBound;
        this.bottomBound = bottomBound;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    public PApplet draw(PApplet c) {
        c.noStroke();
        c.fill(0, 255, 127);  // Sea green color for SeaShells
        c.ellipse(x, y, radius * 2, radius * 2);
        return c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SeaShells seaShells = (SeaShells) obj;
        return x == seaShells.x && y == seaShells.y && radius == seaShells.radius &&
               topBound == seaShells.topBound && bottomBound == seaShells.bottomBound &&
               leftBound == seaShells.leftBound && rightBound == seaShells.rightBound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, radius, topBound, bottomBound, leftBound, rightBound);
    }

    @Override
    public String toString() {
        return String.format("SeaShells at (%d, %d) with radius %d", x, y, radius);
    }
}
