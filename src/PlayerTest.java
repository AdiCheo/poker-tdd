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
	public void testGetPlayerId() {
		testObject.setId(0);
		assertTrue(testObject.getId() < 4 && testObject.getId() >= 0);
	}
}
