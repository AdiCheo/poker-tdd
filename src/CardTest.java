import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.TestCase;

public class CardTest extends TestCase {

	Card testObject;
	
	public void setUp(){
		testObject = new Card(1);
	}
	
	@Test	
	public void testCreateCardObject() {
		assertNotNull(testObject);
	}

	@Test
	public void testCardIsSeven() {
		testObject = new Card(7);
		assertTrue(testObject.getValue()==7);
	}

	@Test
	public void testCardIsSpades() {
		testObject = new Card(7, 1);
		assertTrue(testObject.getValue()==7);
	}
}
