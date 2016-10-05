package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import model.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PointTest {
	Point point;
	
	@Before
	public void setUp() throws Exception {
		point = new Point(15, 80);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEquality() {
		Point tmpPoint = new Point(15, 80);
		assertEquals(point, tmpPoint);
		
		Point newTmpPoint = new Point(19, 30);
		assertNotEquals(point, newTmpPoint);
	}
	
	@Test
	public void testSame(){
		Point tmpPoint = new Point(15, 80);

		assertSame(point, point);
		assertNotSame(point, tmpPoint);
		
	}
}
