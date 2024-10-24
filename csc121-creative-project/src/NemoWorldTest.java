import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NemoWorldTest {

	int screenWidth = 400;
    int screenHeight = 400;

    Shark s1 = new Shark(new Posn(100, 100), new Posn(2, 0), new Posn(100, 400), 5, 10, screenWidth, screenHeight);
    Shark s2 = new Shark(new Posn(100, 200), new Posn(2, 0), new Posn(100, 400), 5, 10, screenWidth, screenHeight);
    Shark s3 = new Shark(new Posn(100, 300), new Posn(2, 0), new Posn(100, 400), 5, 10, screenWidth, screenHeight);
    Shark s4 = new Shark(new Posn(300, 200), new Posn(2, 0), new Posn(300, 400), 5, 10, screenWidth, screenHeight);

	Wall w1 = new Wall(new Posn(100, 100), 10);
	Wall w2 = new Wall(new Posn(200, 100), 10);
	Wall w3 = new Wall(new Posn(300, 300), 10);
	Wall w4 = new Wall(new Posn(400, 300), 10);
	
	Nemo n = new Nemo(new Posn(100,100), 30, 30, 2, 30, 30, 30, 30);
	
	SeaShells ss = new SeaShells(new Posn(150, 150), 10, 0, 400, 0, 400);

	ILoT<Shark> sharkList = new Cons<Shark>(s1,
			new Cons<Shark>(s2, 
					new Cons<Shark>(s3,
							new Cons<Shark>(s4,
									new MT<Shark>()))));
	ILoT<Wall> wallList = new Cons<Wall>(w1,
			new Cons<Wall>(w2, 
					new Cons<Wall>(w3,
							new Cons<Wall>(w4,
									new MT<Wall>()))));
	
	
	NemoWorld world1 = new NemoWorld(sharkList, wallList, n, ss);
	 

	@Test
	void testUpdate() {
		// Initial position of shark s1
        assertEquals(100, s1.getLeft());

        // Update
        IWorld updatedWorld = world1.update();

        // Check if shark s1 moved 2 units to the right
        Shark updatedS1 = ((Cons<Shark>) ((NemoWorld) updatedWorld).sharkList).first;
        assertEquals(102, updatedS1.getLeft());
    }
	
	
	
	@Test
	void testCheckHit() {
		assertEquals( false, n.hitShark(sharkList) );
		
		assertEquals( true, s2.checkHit(new Posn(132, 205), 15));		// s2's hit center is at (100 + 30, 200)
		
		
	}

}
