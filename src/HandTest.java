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
	public void testEmptyHand() {
		assertNull(testObject.getHand());
	}

	@Test
	public void testAddCard() {
		testObject.addCard(new Card("ten"));
		assertTrue(testObject.getCards().get(0).getValue().contentEquals("ten"));
	}

	@Test
	public void testPrintHand() {
		testObject.addCard(new Card("ten"));
//		System.out.print(testObject.getHand().get(0).getValue());
		assertNotNull(testObject.getHand());
	}
	

	@Test
	public void testHandIsRoyalFLush() {
		String[] cards = {"ten", "jack", "queen", "king", "ace"};
		testObject.initCardsWithStrings(cards);
		
		for(int i=0;i<5;i++){
			System.out.print("I:" + cards[i]);
			System.out.print("O" + testObject.getCards().get(i).getValue());
		}
		
		assertTrue(testObject.isRoyalFlush());
	}

}
