import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	Game pokerGame;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
	    System.setOut(new PrintStream(outContent));
	    
		pokerGame = new Game();
	}

	@Test
	public void testCreateNewGame() {
		assertNotNull(pokerGame);
	}

	@Test
	public void testNewGameAsksForNomberOfPlayer() {
	    assertEquals("Welcome to PokerTDD - How many players are present?", outContent.toString().trim());
	}	
	
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

}
