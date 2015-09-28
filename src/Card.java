
public class Card {
	
	int value;
	private int suit;

	public Card(int v, int s) {
		setValue(v);
		setSuit(s);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int v) {
		value = v;
	}

	public void setSuit(int s) {
		this.suit = s;
	}

	public int getSuit() {
		return this.suit;
	}

	public String getStringValue() {
		switch (this.value) {
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		case 14:
			return "Ace";

		default:
			return null;
		}
	}
	public String getStringSuit() {

		switch (this.suit) {
		case 1:
			return "Diamonds";
		case 2:
			return "Clubs";
		case 3:
			return "Hearts";
		case 4:
			return "Spades";
		
		default:
			return null;
		}
	}
	
}
