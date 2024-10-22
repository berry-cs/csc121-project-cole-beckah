
import java.util.Objects;

/** represents a list of
 * things of the 'same' type (where
 * the type could be anything) */
public interface ILoT<Z> {

}


/** represents an empty
 * list of anything */
class MT<S> implements ILoT<S> {
	
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
class Cons<T> implements ILoT<T> {
	 T first;
	 ILoT<T> rest;
	 
	Cons(T first, ILoT<T> rest) {
		super();
		this.first = first;
		this.rest = rest;
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
