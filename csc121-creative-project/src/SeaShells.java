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

    public PApplet draw(PApplet canvas) {
        canvas.noStroke();
        canvas.fill(0, 255, 127);  // Sea green color for SeaShells
        canvas.ellipse(x, y, radius * 2, radius * 2);
        return canvas;
    }
}
