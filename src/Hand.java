import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>(5);

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
