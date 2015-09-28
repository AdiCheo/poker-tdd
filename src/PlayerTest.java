import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player testObject;

	@Before
	public void setUp() throws Exception {
		testObject = new Player();
	}

	@Test
	public void testCreatePlayer() {
		assertNotNull(testObject);
	}

	@Test
	public void testPlayerId() {
		testObject.setId(0);
		assertTrue(testObject.getId() < 4 && testObject.getId() >= 0);
	}

	@Test
	public void testCreatePlayerHand() {
		testObject.setHand("AceHearts AceSpades AceClubs AceDiamonds KingHearts");
		assertNotNull(testObject.getHandString());
	}

	@Test
	public void testCreatePlayerHandContent() {
		testObject.setHand("AceHearts AceSpades AceClubs AceDiamonds KingHearts");
		assertEquals("AceHearts AceSpades AceClubs AceDiamonds KingHearts", testObject.getHandString());
	}

	@Test
	public void testHandRank() {
		testObject.setHand("AceHearts AceSpades AceClubs AceDiamonds KingHearts");
		assertEquals("AceHearts AceSpades AceClubs AceDiamonds KingHearts", testObject.getHandString());
		assertArrayEquals(new int[]{8, 14}, testObject.getHandRank());
	}

	@Test
	public void testCompareTwoPlayersHands() {

		Player[] playersArr = new Player[2];
		playersArr[0] = new Player();
		playersArr[1] = new Player();
		playersArr[0].setHand("KingSpades AceHearts TwoDiamonds OneClubs NineSpades");
		playersArr[1].setHand("AceSpades KingSpades QueenSpades JackSpades TenSpades");
		List<Player> players = new ArrayList<Player>(Arrays.asList(playersArr));
		Collections.sort(players, Player.getCompByHandRank());
		
		assertArrayEquals(new int[]{10,14}, players.get(0).getHandRank());
	}
}
