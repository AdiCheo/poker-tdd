import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>(5);

	public Hand(String s) {
		String[] individualCards = s.split(" ");
		for ( String c : individualCards) {
			int suit;
			if (c.charAt(c.length()-2) == 't') {
				suit = 1;
				addCard(c.substring(0, c.length()-6).toLowerCase());
			}
			else if (c.charAt(c.length()-2) == 'e') {
				suit = 2;
				addCard(c.substring(0, c.length()-6).toLowerCase());
			}
			else if (c.charAt(c.length()-2) == 'd') {
				suit = 2;
				addCard(c.substring(0, c.length()-8).toLowerCase());
			}
			else if (c.charAt(c.length()-2) == 'b') {
				suit = 2;
				addCard(c.substring(0, c.length()-5).toLowerCase());
			}
		}
	}

	private void addCard(String c) {
		if (c.equalsIgnoreCase("ace")){
			addCard(new Card(14));
		}
		else if (c.equalsIgnoreCase("king")){
			addCard(new Card(13));
		}
		else if (c.equalsIgnoreCase("queen")){
			addCard(new Card(12));
		}
		else if (c.equalsIgnoreCase("jack")){
			addCard(new Card(11));
		}
		else if (c.equalsIgnoreCase("ten")){
			addCard(new Card(10));
		}
		else if (c.equalsIgnoreCase("nine")){
			addCard(new Card(9));
		}
		else if (c.equalsIgnoreCase("eight")){
			addCard(new Card(8));
		}
		else if (c.equalsIgnoreCase("seven")){
			addCard(new Card(7));
		}
		else if (c.equalsIgnoreCase("six")){
			addCard(new Card(6));
		}
		else if (c.equalsIgnoreCase("five")){
			addCard(new Card(5));
		}
		else if (c.equalsIgnoreCase("four")){
			addCard(new Card(4));
		}
		else if (c.equalsIgnoreCase("three")){
			addCard(new Card(3));
		}
		else if (c.equalsIgnoreCase("two")){
			addCard(new Card(2));
		}
		else if (c.equalsIgnoreCase("one")){
			addCard(new Card(1));
		}
	}

	public Hand() {
	}

	public Card findInCards(int v) {
		for (int i=0;i<5;i++){
			if(cards.get(i).getValue()==(v)){
				return cards.get(i);
			}
		}
		return null;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void addCard(Card c) {
		cards.add(c);
	}

	public void initCardsWithStrings(int[] cards) {
		for(int i=0;i<5;i++){
			addCard(new Card(cards[i]));
		}
	}
	
	public boolean isRoyalFlush() {
		if (cards.get(0).getValue() == 10 ) {
			return true;
		}
		return false;
	}

	public ArrayList<Card> getHand() {
		if (cards.size() == 0)
			return null;
		
		return cards;
	}
}
