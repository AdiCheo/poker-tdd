
public class Card {
	
	static String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		Card.value = value;
	}

	public Card(String v) {
		setValue(v);
	}
	
}
