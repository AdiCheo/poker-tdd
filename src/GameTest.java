import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	Game pokerGame;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
	    System.setOut(new PrintStream(outContent));
		pokerGame = new Game(2);
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
	public void testCreateDistributeHands() {
		pokerGame = new Game(4);
		pokerGame.givePlayerHand(0, "AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts");
		pokerGame.givePlayerHand(1, "FourSpades SixHearts SevenDiamonds EightClubs NineHearts");
		pokerGame.givePlayerHand(2, "TenSpades JackHearts QueenDiamonds KingClubs AceHearts");
		pokerGame.givePlayerHand(3, "ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts");

		assertEquals("AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts", pokerGame.getPlayers().get(0).getHand());
		assertEquals("FourSpades SixHearts SevenDiamonds EightClubs NineHearts", pokerGame.getPlayers().get(1).getHand());
		assertEquals("TenSpades JackHearts QueenDiamonds KingClubs AceHearts", pokerGame.getPlayers().get(2).getHand());
		assertEquals("ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts", pokerGame.getPlayers().get(3).getHand());
	}

	@Test
	public void testDuplicateCard() {
		pokerGame = new Game(4);
		pokerGame.givePlayerHand(0, "AceSpades AceSpades ThreeDiamonds FiveClubs TwoHearts");
		pokerGame.givePlayerHand(1, "FourSpades SixHearts SevenDiamonds EightClubs NineHearts");
		pokerGame.givePlayerHand(2, "TenSpades AceSpades QueenDiamonds KingClubs AceHearts");
		pokerGame.givePlayerHand(3, "ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts");
		assertEquals("AceSpades ThreeDiamonds FiveClubs TwoHearts", pokerGame.getPlayers().get(0).getHand());
		assertEquals("FourSpades SixHearts SevenDiamonds EightClubs NineHearts", pokerGame.getPlayers().get(1).getHand());
		assertEquals("TenSpades QueenDiamonds KingClubs AceHearts", pokerGame.getPlayers().get(2).getHand());
		assertEquals("ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts", pokerGame.getPlayers().get(3).getHand());
	}

	@Test
	public void testRankHands() {
		pokerGame = new Game(4);
		pokerGame.givePlayerHand(0, "AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts");
		pokerGame.givePlayerHand(1, "FourSpades SixHearts SevenDiamonds EightClubs NineHearts");
		pokerGame.givePlayerHand(2, "TenSpades JackHearts QueenDiamonds KingClubs AceHearts");
		pokerGame.givePlayerHand(3, "ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts");
		
		List<Player> players = new ArrayList<Player>(pokerGame.players);
		Collections.sort(players, Player.getCompByHandRank());

		assertArrayEquals(new int[]{5,14}, players.get(0).getHandRank());
		assertArrayEquals(new int[]{1,14}, players.get(1).getHandRank());
		assertArrayEquals(new int[]{1,12}, players.get(2).getHandRank());
		assertArrayEquals(new int[]{1,9}, players.get(3).getHandRank());

		assertEquals("TenSpades JackHearts QueenDiamonds KingClubs AceHearts", players.get(0).getHand());
		assertEquals("AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts", players.get(1).getHand());
		assertEquals("ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts", players.get(2).getHand());
		assertEquals("FourSpades SixHearts SevenDiamonds EightClubs NineHearts", players.get(3).getHand());

		assertEquals("AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts", pokerGame.getPlayers().get(0).getHand());
		assertEquals("FourSpades SixHearts SevenDiamonds EightClubs NineHearts", pokerGame.getPlayers().get(1).getHand());
		assertEquals("TenSpades JackHearts QueenDiamonds KingClubs AceHearts", pokerGame.getPlayers().get(2).getHand());
		assertEquals("ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts", pokerGame.getPlayers().get(3).getHand());
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

}
