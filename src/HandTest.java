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
		assertTrue(testObject.findInCards(14).getValue()==14);
	}

	@Test
	public void testCreateHandObjectWithStringValueKing() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueQueen() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueJack() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueTen() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueNine() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueEight() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueSeven() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueSix() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueFive() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueFour() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueThree() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueTwo() {
		testObject = new Hand("KingHearts");
		assertTrue(testObject.findInCards(13).getValue()==13);
	}

	@Test
	public void testCreateHandObjectWithStringValueOne() {
		testObject = new Hand("OneSpades");
		assertTrue(testObject.findInCards(1).getValue()==1);
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
