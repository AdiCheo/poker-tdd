import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.TestCase;

public class CardTest extends TestCase {

	Card testObject;
	
	public void setUp(){
		testObject = new Card(1, 1);
	}
	
	@Test	
	public void testCreateCardObject() {
		assertNotNull(testObject);
	}

	@Test
	public void testCardIsSeven() {
		testObject = new Card(7, 1);
		assertTrue(testObject.getValue()==7);
	}

	@Test
	public void testGetStringValue() {
		testObject = new Card(7, 1);
		assertTrue(testObject.getStringValue().equals("Seven"));
	}

	@Test
	public void testGetStringDiamond() {
		testObject = new Card(7, 1);
		assertEquals("Diamonds", testObject.getStringSuit());
	}

	@Test
	public void testGetStringClub() {
		testObject = new Card(7, 2);
		assertEquals("Clubs", testObject.getStringSuit());
	}

	@Test
	public void testGetStringHeart() {
		testObject = new Card(7, 3);
		assertEquals("Hearts", testObject.getStringSuit());
	}

	@Test
	public void testGetStringSpade() {
		testObject = new Card(7, 4);
		assertEquals("Spades", testObject.getStringSuit());
	}
}
