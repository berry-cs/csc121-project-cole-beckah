import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NemoWorldTest {

	NemoWorld w1 = new NemoWorld(
			new Shark(new Posn(200, 200), new Posn(2, 0), new Posn(200, 400), 5, 10),
			new Wall(new Posn(100, 100), 50, 10));
	NemoWorld w2 = new NemoWorld(
    		new Shark(new Posn(202, 200), new Posn(2, 0), new Posn(200, 400), 5, 10),
    		new Wall(new Posn(100, 100), 50, 10));
					
	@Test
	void testUpdate() {
		assertEquals(w2, w1.update());
	}

}
