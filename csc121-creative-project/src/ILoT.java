import java.util.Objects;
import processing.core.PApplet;

/** represents a list of
 * things of the 'same' type (where
 * the type could be anything) */
public interface ILoT<Z> extends Drawable{
	void draw(PApplet c);
}


/** represents an empty
 * list of anything */
class MT<S extends Drawable> implements ILoT<S> {

	public void draw(PApplet c) {
        // Do nothing for an empty list
    }
	
	@Override
	public boolean equals(Object other) {
		return other instanceof MT;
	}

	@Override
	public int hashCode() {
		return MT.class.hashCode();
	}

	@Override
	public String toString() {
		return "MT<S> []";
	}

}


/** to represent a list
 * with something added to it */
class Cons<T extends Drawable> implements ILoT<T> {
	T first;
	ILoT<T> rest;

	Cons(T first, ILoT<T> rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	public void draw(PApplet c) {
        first.draw(c);
        rest.draw(c);
    }

	@Override
	public int hashCode() {
		return Objects.hash(first, rest);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cons other = (Cons) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}


}
