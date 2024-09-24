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

    public PApplet draw(PApplet canvas) {
        canvas.noStroke();
        canvas.fill(255, 200, 0);  // Yellow color for Nemo
        canvas.rect(x, y, width, height);
        return canvas;
    }
}
