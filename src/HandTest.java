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
	public void testCreateHandObjectWithString() {
		testObject = new Hand("AceHearts AceSpades AceClubs AceDiamonds KingHearts");
		assertNotNull(testObject);
	}

	@Test
	public void testEmptyHand() {
		assertNull(testObject.getHand());
	}

	@Test
	public void testAddCard() {
		testObject.addCard(new Card(10));
		assertTrue(testObject.getCards().get(0).getValue()==10);
	}

	@Test
	public void testPrintHand() {
		testObject.addCard(new Card(10));
//		System.out.print(testObject.getHand().get(0).getValue());
		assertNotNull(testObject.getHand());
	}
}
