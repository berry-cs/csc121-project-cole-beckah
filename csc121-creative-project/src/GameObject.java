import processing.core.PApplet;

public interface GameObject<T> {
    void draw(PApplet c);
    T update();
    boolean checkHit(Posn ctr, int rad);
}
