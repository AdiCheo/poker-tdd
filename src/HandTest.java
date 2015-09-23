import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HandTest {

	Hand testObject;

	@Before
	public void setUp() throws Exception {
		testObject = new Hand();
	}

	@Test
	public void testCreateHandObject() {
		assertNotNull(testObject);
	}

	@Test
	public void testHandIsRoyalFLush() {
		String[] cards = new String[5];
		cards[0] = ("ten");
		cards[1] = ("jack");
		cards[2] = ("queen");
		cards[3] = ("king");
		cards[4] = ("ace");
		testObject.initCardsWithStrings(cards);
		assertTrue(testObject.isRoyalFlush());
	}

}
