import processing.core.PApplet;

public class Nemo extends PApplet {
    int x;
    int y;
    int width;
    int height;
    boolean isMovingUp;
    boolean isMovingDown;
    boolean isMovingLeft;
    boolean isMovingRight;
    int playerSpeed;
    int topBound;
    int bottomBound;
    int leftBound;
    int rightBound;

    public Nemo(int x, int y, int width, int height, int playerSpeed,
                int topBound, int bottomBound, int leftBound, int rightBound) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playerSpeed = playerSpeed;
        this.topBound = topBound;
        this.bottomBound = bottomBound;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    public void move() {
        if (isMovingUp && y > topBound) {
            y -= playerSpeed;
        }
        if (isMovingDown && y + height < bottomBound) {
            y += playerSpeed;
        }
        if (isMovingLeft && x > leftBound) {
            x -= playerSpeed;
        }
        if (isMovingRight && x + width < rightBound) {
            x += playerSpeed;
        }
    }

    public PApplet draw(PApplet c) {
        c.noStroke();
        c.fill(255, 200, 0);  // Yellow color for Nemo
        c.rect(x, y, width, height);
        return c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Nemo nemo = (Nemo) obj;
        return x == nemo.x && y == nemo.y && width == nemo.width && height == nemo.height &&
               topBound == nemo.topBound && bottomBound == nemo.bottomBound &&
               leftBound == nemo.leftBound && rightBound == nemo.rightBound &&
               playerSpeed == nemo.playerSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height, topBound, bottomBound, leftBound, rightBound, playerSpeed);
    }

    @Override
    public String toString() {
        return String.format("Nemo at (%d, %d) with size (%d x %d)", x, y, width, height);
    }
}
