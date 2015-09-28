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
		assertNotNull(pokerGame.getPlayers());
		assertNotNull(pokerGame.getPlayers().get(0));
		assertNotNull(pokerGame.getPlayers().get(1));
		assertNotNull(pokerGame.getPlayers().get(2));
		assertNotNull(pokerGame.getPlayers().get(3));
	}
	

	@Test
	public void testCreatePlayersAndDistributeHands() {
		pokerGame = new Game(4);
		pokerGame.givePlayerHand(0, "AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts");
		pokerGame.givePlayerHand(1, "FourSpades SixHearts SevenDiamonds EightClubs NineHearts");
		pokerGame.givePlayerHand(2, "TenSpades JackHearts QueenDiamonds KingClubs AceHearts");
		pokerGame.givePlayerHand(3, "ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts");
	}	
	
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

}
