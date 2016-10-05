package test;

import static org.junit.Assert.*;
import model.Link;
import model.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkTest {
	Link link;
	
	@Before
	public void setUp() throws Exception {
		link = new Link();
		link.addPoint(new Point(15, 78));
		link.addPoint(new Point(30, 93));
	}

	@After
	public void tearDown() throws Exception {
		link.removeAllPoint();
	}

	
	@Test
	public void sameLinks(){
		Link temp = new Link();
		temp.addPoint(new Point(15, 78));
		temp.addPoint(new Point(30, 93));
		
		assertTrue(temp.getPoints().containsAll(link.getPoints()));
	}
}
