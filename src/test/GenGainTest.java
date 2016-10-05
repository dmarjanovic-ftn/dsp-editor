package test;

import static org.junit.Assert.*;
import model.GenGain;
import model.Point;
import model.Terminal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GenGainTest {
	GenGain gain;
	
	@Before
	public void setUp() throws Exception {
		gain = new GenGain("gen gain comp", "desc", 15);
	}

	@After
	public void tearDown() throws Exception {
		gain.removeAllTerminals();
	}

	@Test 
	public void initializedCollection(){
		assertNotNull(gain.getTerminals());
	}
	
	@Test
	public void emptyCollection() {
		assertTrue(gain.getTerminals().isEmpty());
	}
	
	@Test
	public void twoElemInCollection() {
		gain.addTerminal(new Terminal(2, Terminal.TerminalType.OUTPUT, new Point(30, 25)));
		gain.addTerminal(new Terminal(1, Terminal.TerminalType.INPUT, new Point(15, 56)));
		assertEquals(2, gain.getTerminals().size());
	}
	
}
