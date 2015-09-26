import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	Game pokerGame;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateNewGame() {
		pokerGame = new Game();
		assertNotNull(pokerGame);
	}

}
