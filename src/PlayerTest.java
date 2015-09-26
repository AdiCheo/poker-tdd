import static org.junit.Assert.*;

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
		assertNotNull(testObject.getHand());
	}
}
