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
	public void testNewGameAsksForNumberOfPlayer() {
	    assertEquals("Welcome to PokerTDD - How many players are present?", outContent.toString().trim());
	}	

	@Test
	public void testCreateGameWithFourPlayers() {
		pokerGame = new Game(4);
		assertNotNull(pokerGame);
	}	
	
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

}
