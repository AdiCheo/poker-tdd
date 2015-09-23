
public class Hand {
	private static Card[] cards;

	public static Card[] getCards() {
		return cards;
	}

	public static void setCards(Card[] cards) {
		Hand.cards = cards;
	}

	public void initCardsWithStrings(String[] cards) {
		Card[] tempCards = new Card[5]; 
		for(int i=0;i<5;i++){
			tempCards[i] = new Card(cards[i]);
		}
		setCards(tempCards);
	}

	public boolean isRoyalFlush() {
		return true;
	}
}
