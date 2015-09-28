import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>(5);

	public Hand(String s) {
		String[] individualCards = s.split(" ");
		for ( String c : individualCards) {
			if (c.charAt(c.length()-2) == 'e') {
				addCard(c.substring(0, c.length()-6), 4);
			}
			else if (c.charAt(c.length()-2) == 't') {
				addCard(c.substring(0, c.length()-6), 3);
			}
			else if (c.charAt(c.length()-2) == 'b') {
				addCard(c.substring(0, c.length()-5), 2);
			}
			else if (c.charAt(c.length()-2) == 'd') {
				addCard(c.substring(0, c.length()-8), 1);
			}
		}
	}

	private void addCard(String c, int s) {
		if (c.equalsIgnoreCase("ace")){
			addCard(new Card(14, s));
		}
		else if (c.equalsIgnoreCase("king")){
			addCard(new Card(13, s));
		}
		else if (c.equalsIgnoreCase("queen")){
			addCard(new Card(12, s));
		}
		else if (c.equalsIgnoreCase("jack")){
			addCard(new Card(11, s));
		}
		else if (c.equalsIgnoreCase("ten")){
			addCard(new Card(10, s));
		}
		else if (c.equalsIgnoreCase("nine")){
			addCard(new Card(9, s));
		}
		else if (c.equalsIgnoreCase("eight")){
			addCard(new Card(8, s));
		}
		else if (c.equalsIgnoreCase("seven")){
			addCard(new Card(7, s));
		}
		else if (c.equalsIgnoreCase("six")){
			addCard(new Card(6, s));
		}
		else if (c.equalsIgnoreCase("five")){
			addCard(new Card(5, s));
		}
		else if (c.equalsIgnoreCase("four")){
			addCard(new Card(4, s));
		}
		else if (c.equalsIgnoreCase("three")){
			addCard(new Card(3, s));
		}
		else if (c.equalsIgnoreCase("two")){
			addCard(new Card(2, s));
		}
		else if (c.equalsIgnoreCase("one")){
			addCard(new Card(1, s));
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
			addCard(new Card(cards[i], 1));
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

	public String getHandString() {
		if (cards.size() == 0)
			return "";
		String handString = "";
		for (Card c : cards){
			handString = handString + c.getStringValue() + c.getStringSuit() + " ";
		}
		return handString.trim();
	}

	public int[] getHandRank() {
		int highCard = 0;
		int handRank = 0; // 10:RoyalFlush, 9:StraightFlush, 8:FourKind, 7:FullHouse, 6:Flush, 5:Straight, 4:ThreeKind, 3:TwoPair, 2:OnePair, 1:HighCard
		for (Card c : cards){
			int value = c.getValue();
			if (value > highCard){
				highCard = value;
				handRank = 1;
			}
		}
		handRank = checkPair(highCard, handRank);
		handRank = checkStraightFlush(highCard, handRank);
		handRank = checkRoyalFlush(highCard, handRank);
		
		return new int[]{handRank, highCard};
	}

	private int checkPair(int highCard, int handRank) {
		int firstPairValue = 0;
		for (Card c : cards){
			for (Card b : cards){
				if (firstPairValue > 0 && c.getValue() == b.getValue() && !c.equals(b) && c.getValue() != firstPairValue){
					handRank = 3;				
				}
				else if (c.getValue() == b.getValue() && !c.equals(b)){
					handRank = 2;
					firstPairValue = c.getValue();
				}
			}
		}
		return handRank;
	}

	private int checkStraightFlush(int highCard, int handRank) {
		int suit = findInCards(highCard).getSuit();
		for (int i = highCard-1; i > highCard-5; i--){
			if (findInCards(i) == null || findInCards(i).getSuit() != suit){
				return handRank;
			}
			if (i == highCard-4){
				handRank = 9;
			}
		}
		return handRank;
	}

	private int checkRoyalFlush(int highCard, int handRank) {
		if (highCard == 14){ // Test for royal flush
			int suit = findInCards(14).getSuit();
			int i;
			for (i = 13; i > 9; i--){
				if (findInCards(i).getSuit() != suit){
					break;
				}
			}
			if (i == 9){
				handRank = 10;
			}
		}
		return handRank;
	}
}
