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
	public void testFourKind() {
		testObject = new Hand("KingSpades KingHearts KingDiamonds KingClubs TwoSpades");

		assertEquals("KingSpades KingHearts KingDiamonds KingClubs TwoSpades", testObject.getHandString());
		assertArrayEquals(new int[]{8, 13}, testObject.getHandRank());
	}

	@Test
	public void testFullHouse() {
		testObject = new Hand("KingSpades KingHearts KingDiamonds TwoClubs TwoSpades");

		assertEquals("KingSpades KingHearts KingDiamonds TwoClubs TwoSpades", testObject.getHandString());
		assertArrayEquals(new int[]{7, 13}, testObject.getHandRank());
	}

	@Test
	public void testFlush() {
		testObject = new Hand("ThreeSpades FiveSpades QueenSpades JackSpades TenSpades");

		assertEquals("ThreeSpades FiveSpades QueenSpades JackSpades TenSpades", testObject.getHandString());
		assertArrayEquals(new int[]{6, 12}, testObject.getHandRank());
	}

	@Test
	public void testStraight() {
		testObject = new Hand("KingHearts QueenSpades JackClubs TenSpades NineDiamonds");

		assertEquals("KingHearts QueenSpades JackClubs TenSpades NineDiamonds", testObject.getHandString());
		assertArrayEquals(new int[]{5, 13}, testObject.getHandRank());
	}

	@Test
	public void testThreeKind() {
		testObject = new Hand("KingSpades KingHearts KingDiamonds TwoClubs NineSpades");

		assertEquals("KingSpades KingHearts KingDiamonds TwoClubs NineSpades", testObject.getHandString());
		assertArrayEquals(new int[]{4, 13}, testObject.getHandRank());
	}

	@Test
	public void twoPair() {
		testObject = new Hand("KingSpades KingHearts TwoDiamonds TwoClubs NineSpades");

		assertEquals("KingSpades KingHearts TwoDiamonds TwoClubs NineSpades", testObject.getHandString());
		assertArrayEquals(new int[]{3, 13}, testObject.getHandRank());
	}

	@Test
	public void testPair() {
		testObject = new Hand("KingSpades KingHearts TwoDiamonds OneClubs NineSpades");

		assertEquals("KingSpades KingHearts TwoDiamonds OneClubs NineSpades", testObject.getHandString());
		assertArrayEquals(new int[]{2, 13}, testObject.getHandRank());
	}

	@Test
	public void testHighCard() {
		testObject = new Hand("KingSpades AceHearts TwoDiamonds OneClubs NineSpades");

		assertEquals("KingSpades AceHearts TwoDiamonds OneClubs NineSpades", testObject.getHandString());
		assertArrayEquals(new int[]{1, 14}, testObject.getHandRank());
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
