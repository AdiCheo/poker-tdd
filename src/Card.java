
public class Card {
	
	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int v) {
		value = v;
	}

	public Card(int v) {
		setValue(v);
	}

	public String getStringValue() {
		switch (value) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "jack";
		case 12:
			return "queen";
		case 13:
			return "king";
		case 14:
			return "ace";

		default:
			return null;
		}
	}
	
}
