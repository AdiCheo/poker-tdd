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
		testObject.card[0].setValue("ten");
		testObject.card[1].setValue("jack");
		testObject.card[2].setValue("queen");
		testObject.card[3].setValue("king");
		testObject.card[4].setValue("ace");
		assertTrue(testObject.isRoyalFlush());
	}

}
