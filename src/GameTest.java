import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
	    assertEquals("Welcome to PokerTDD", outContent.toString().trim());
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
	public void testCreateGameWithSixPlayers() {
		pokerGame = new Game(6);
		assertNotNull(pokerGame);
		assertNotNull(pokerGame.getPlayers());
		assertEquals(0, pokerGame.getPlayers().size());
	}

	@Test
	public void testCreateGameWithOnePlayer() {
		pokerGame = new Game(1);
		assertNotNull(pokerGame);
		assertNotNull(pokerGame.getPlayers());
		assertEquals(0, pokerGame.getPlayers().size());
	}

	@Test
	public void testCreateDistributeHands() {
		pokerGame = new Game(4);
		pokerGame.givePlayerHand(0, "AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts");
		pokerGame.givePlayerHand(1, "FourSpades SixHearts SevenDiamonds EightClubs NineHearts");
		pokerGame.givePlayerHand(2, "TenSpades JackHearts QueenDiamonds KingClubs AceHearts");
		pokerGame.givePlayerHand(3, "ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts");

		assertEquals("AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts", pokerGame.getPlayers().get(0).getHandString());
		assertEquals("FourSpades SixHearts SevenDiamonds EightClubs NineHearts", pokerGame.getPlayers().get(1).getHandString());
		assertEquals("TenSpades JackHearts QueenDiamonds KingClubs AceHearts", pokerGame.getPlayers().get(2).getHandString());
		assertEquals("ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts", pokerGame.getPlayers().get(3).getHandString());
	}

	@Test
	public void testDistributeBadHands() {
		pokerGame = new Game(4);
		pokerGame.givePlayerHand(0, "ThreeDiamonds FiveClubs TwoHearts");
		pokerGame.givePlayerHand(1, "FourSpades FourSpades SixHearts SevenDiamonds EightClubs NineHearts");
		pokerGame.givePlayerHand(2, "FourSpades TenSpades JackHearts QueenDiamonds KingClubs AceHearts");
		pokerGame.givePlayerHand(3, "FourSpades ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts");

		assertNull(pokerGame.getPlayers().get(0).getHand());
		assertNull( pokerGame.getPlayers().get(1).getHand());
		assertNull(pokerGame.getPlayers().get(2).getHand());
		assertNull(pokerGame.getPlayers().get(3).getHand());
	}

	@Test
	public void testDistributeBadCards() {
		pokerGame = new Game(2);
		pokerGame.givePlayerHand(0, "OneShovel TenSpades JackHearts Brolo KingClubs");
		pokerGame.givePlayerHand(1, "FourSpades ThreeSpades FiveTickets Lallal SixClubs ");

		assertNull(pokerGame.getPlayers().get(0).getHand());
		assertNull(pokerGame.getPlayers().get(1).getHand());
	}

	@Test
	public void testDuplicateCard() {
		pokerGame = new Game(4);
		pokerGame.givePlayerHand(0, "AceSpades AceSpades ThreeDiamonds FiveClubs TwoHearts");
		pokerGame.givePlayerHand(1, "AceSpades SixHearts SevenDiamonds EightClubs NineHearts");
		pokerGame.givePlayerHand(2, "TenSpades AceSpades QueenDiamonds KingClubs AceHearts");
		pokerGame.givePlayerHand(3, "ThreeSpades FiveHearts ThreeDiamonds SixClubs QueenHearts");
		assertNull(pokerGame.getPlayers().get(0).getHand());
		assertEquals("AceSpades SixHearts SevenDiamonds EightClubs NineHearts", pokerGame.getPlayers().get(1).getHandString());
		assertNull(pokerGame.getPlayers().get(2).getHand());
		assertEquals("ThreeSpades FiveHearts ThreeDiamonds SixClubs QueenHearts", pokerGame.getPlayers().get(3).getHandString());
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

		assertEquals("TenSpades JackHearts QueenDiamonds KingClubs AceHearts", players.get(0).getHandString());
		assertEquals("AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts", players.get(1).getHandString());
		assertEquals("ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts", players.get(2).getHandString());
		assertEquals("FourSpades SixHearts SevenDiamonds EightClubs NineHearts", players.get(3).getHandString());

		assertEquals("AceSpades KingHearts ThreeDiamonds FiveClubs TwoHearts", pokerGame.getPlayers().get(0).getHandString());
		assertEquals("FourSpades SixHearts SevenDiamonds EightClubs NineHearts", pokerGame.getPlayers().get(1).getHandString());
		assertEquals("TenSpades JackHearts QueenDiamonds KingClubs AceHearts", pokerGame.getPlayers().get(2).getHandString());
		assertEquals("ThreeSpades FiveHearts TwoDiamonds SixClubs QueenHearts", pokerGame.getPlayers().get(3).getHandString());
	}

	@Test
	public void testRankHandsTwoRoyalFlush() {
		pokerGame = new Game(2);
		pokerGame.givePlayerHand(0, "AceSpades KingSpades QueenSpades JackSpades TenSpades");
		pokerGame.givePlayerHand(1, "AceHearts KingHearts QueenHearts JackHearts TenHearts");

		List<Player> players = new ArrayList<Player>(pokerGame.players);
		Collections.sort(players, Player.getCompByHandRank());

		assertArrayEquals(new int[]{10,14}, players.get(0).getHandRank());
		assertArrayEquals(new int[]{10,14}, players.get(1).getHandRank());

		assertEquals("AceSpades KingSpades QueenSpades JackSpades TenSpades", players.get(0).getHandString());
		assertEquals("AceHearts KingHearts QueenHearts JackHearts TenHearts", players.get(1).getHandString());
	
		assertEquals("AceSpades KingSpades QueenSpades JackSpades TenSpades", pokerGame.getPlayers().get(0).getHandString());
		assertEquals("AceHearts KingHearts QueenHearts JackHearts TenHearts", pokerGame.getPlayers().get(1).getHandString());
		}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

}
