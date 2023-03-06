import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook gradebook1, gradebook2;
	
	@BeforeEach
	void setUp() throws Exception {
	gradebook1 = new GradeBook(5);
	gradebook2 = new GradeBook(5);
	gradebook1.addScore(50.0);
	gradebook1.addScore(75.5);
	gradebook1.addScore(10.9);
	gradebook2.addScore(85.8);
	gradebook2.addScore(99.9);
	}
	

	@AfterEach
	void tearDown() throws Exception {
		gradebook1 = gradebook2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gradebook1.toString().equals("50.0 75.5 10.9 "));
		assertTrue(gradebook2.toString().equals("85.8 99.9 "));
		assertEquals(3,gradebook1.getScoreSize());
		assertEquals(2,gradebook2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(136.4,gradebook1.sum(),0.0001);
		assertEquals(185.7,gradebook2.sum(),0.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(10.9, gradebook1.minimum(),0.001);
		assertEquals(85.8, gradebook2.minimum(),0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(125.5, gradebook1.finalScore(),0.001);
		assertEquals(99.9, gradebook2.finalScore(),0.001);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(3,gradebook1.getScoreSize());
		assertEquals(2,gradebook2.getScoreSize());
	}

	@Test
	void testToString() {
		assertEquals("50.0 75.5 10.9 ",gradebook1.toString());
		assertEquals("85.8 99.9 ", gradebook2.toString());
	}

}
