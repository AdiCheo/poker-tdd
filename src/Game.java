import java.util.ArrayList;

public class Game {
	public Game(int p) {
		players = new ArrayList<Player>(4);
		System.out.println("Welcome to PokerTDD");
		if(p>1 && p<5){
			for (int i=0;i<p;i++){
				players.add(new Player());
			}
		}
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	ArrayList<Player> players;

	public void givePlayerHand(int p, String h) {
		if (cardsAreGood(h))
			players.get(p).setHand(h);
	}

	private boolean cardsAreGood(String h) {
		Hand tmpHand = new Hand(h);
		// Check for less than or more than 5 cards
		if (tmpHand.getCards().size() != 5){
			return false;
		}
		//Check tmpHand does not contain duplicates
		for (int i=0;i<5;i++){
			for (int j=0;j<5;j++){
				Card b = tmpHand.getCards().get(i);
				Card c = tmpHand.getCards().get(j);
				if (b.getValue() == c.getValue() && b.getSuit() == c.getSuit() && i != j){
					System.out.print(b.getStringValue() + b.getStringSuit() + " is a duplicate card. Try entering the hand again");
					return false;
				}
				
			}
		}
		// Check existing players don't hold duplicate
		for (Player p : players){
			if(p.getHand() == null)
				continue;
			for (Card c: p.getHand().getCards()){
				for (Card b : tmpHand.getCards()){
					if (b.getValue() == c.getValue() && b.getSuit() == c.getSuit()){
						System.out.print(b.getStringValue() + b.getStringSuit() + " is a duplicate card. Try entering the hand again");
						return false;
					}
				}
			}
			
		}
		return true;
	}

}
