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
	public void testCreateHandObjectWithStringNotNull() {
		testObject = new Hand("AceHearts AceSpades AceClubs AceDiamonds KingHearts");
		assertNotNull(testObject);
	}

	@Test
	public void testCreateHandObjectWithStringValueAce() {
		testObject = new Hand("AceHearts");
		assertNotNull(testObject.findInCards(14));
	}

	@Test
	public void testCreateHandObjectWithStringValueKing() {
		testObject = new Hand("KingHearts");
		assertNotNull(testObject.findInCards(13));
	}

	@Test
	public void testCreateHandObjectWithStringValueQueen() {
		testObject = new Hand("QueenDiamonds");
		assertNotNull(testObject.findInCards(12));
	}

	@Test
	public void testCreateHandObjectWithStringValueJack() {
		testObject = new Hand("JackClubs");
		assertNotNull(testObject.findInCards(11));
	}

	@Test
	public void testCreateHandObjectWithStringValueTen() {
		testObject = new Hand("TenHearts");
		assertNotNull(testObject.findInCards(10));
	}

	@Test
	public void testCreateHandObjectWithStringValueNine() {
		testObject = new Hand("NineHearts");
		assertNotNull(testObject.findInCards(9));
	}

	@Test
	public void testCreateHandObjectWithStringValueEight() {
		testObject = new Hand("EightHearts");
		assertNotNull(testObject.findInCards(8));
	}

	@Test
	public void testCreateHandObjectWithStringValueSeven() {
		testObject = new Hand("SevenHearts");
		assertNotNull(testObject.findInCards(7));
	}

	@Test
	public void testCreateHandObjectWithStringValueSix() {
		testObject = new Hand("SixHearts");
		assertNotNull(testObject.findInCards(6));
	}

	@Test
	public void testCreateHandObjectWithStringValueFive() {
		testObject = new Hand("FiveHearts");
		assertNotNull(testObject.findInCards(5));
	}

	@Test
	public void testCreateHandObjectWithStringValueFour() {
		testObject = new Hand("FourHearts");
		assertNotNull(testObject.findInCards(4));
	}

	@Test
	public void testCreateHandObjectWithStringValueThree() {
		testObject = new Hand("ThreeHearts");
		assertNotNull(testObject.findInCards(3));
	}

	@Test
	public void testCreateHandObjectWithStringValueTwo() {
		testObject = new Hand("TwoHearts");
		assertNotNull(testObject.findInCards(2));
	}

	@Test
	public void testCreateHandObjectWithStringValueOne() {
		testObject = new Hand("OneSpades");
		assertNotNull(testObject.findInCards(1));
	}

	@Test
	public void testCreateHandObjectWithStringValues() {
		testObject = new Hand("OneSpades TwoClubs ThreeDiamonds FourHearts FiveHearts");
		assertEquals("OneSpades TwoClubs ThreeDiamonds FourHearts FiveHearts", testObject.getHandString());
	}

	@Test
	public void testRoyalFlush() {
		testObject = new Hand("AceSpades KingSpades QueenSpades JackSpades TenSpades");

		assertEquals("AceSpades KingSpades QueenSpades JackSpades TenSpades", testObject.getHandString());
		assertArrayEquals(new int[]{10, 14}, testObject.getHandRank());
	}

	@Test
	public void testStraightFlush() {
		testObject = new Hand("KingSpades QueenSpades JackSpades TenSpades NineSpades");

		assertEquals("KingSpades QueenSpades JackSpades TenSpades NineSpades", testObject.getHandString());
		assertArrayEquals(new int[]{9, 13}, testObject.getHandRank());
	}

	@Test
	public void testEmptyHand() {
		assertNull(testObject.getHand());
	}

	@Test
	public void testAddCard() {
		testObject.addCard(new Card(10, 1));
		assertTrue(testObject.getCards().get(0).getValue()==10);
	}

	@Test
	public void testPrintHand() {
		testObject.addCard(new Card(10, 1));
//		System.out.print(testObject.getHand().get(0).getValue());
		assertNotNull(testObject.getHand());
	}
}
