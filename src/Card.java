
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

	public int getIntValue() {
		switch (value.toLowerCase()) {
		case "one":
			return 1;
		case "two":
			return 2;
		case "three":
			return 3;
		case "four":
			return 4;
		case "five":
			return 5;
		case "six":
			return 6;
		case "seven":
			return 7;
		case "eight":
			return 8;
		case "nine":
			return 9;
		case "ten":
			return 10;
		case "jack":
			return 11;
		case "queen":
			return 12;
		case "king":
			return 13;
		case "ace":
			return 14;

		default:
			return -1;
		}
	}
	
}
