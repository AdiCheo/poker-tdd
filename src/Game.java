import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
	public Game(int p) {
		System.out.println("Welcome to PokerTDD");
		int numPlayers = p;
		if (numPlayers == -1) {
			Scanner in = new Scanner(System.in);

			while ( numPlayers < 2 || numPlayers > 4){
				System.out.println("How many players are present? (2-4)");
				System.out.print("> ");
				numPlayers = in.nextInt();
			}
		}
		players = new ArrayList<Player>(numPlayers);
		if ( numPlayers > 1 && numPlayers <5){
			for (int i=0;i<numPlayers;i++){
				players.add(new Player(i));
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
	
	public static void main(String[] args){
		Game g = new Game(-1);
		printPlayerIds(g);
		while(playersDontHaveCards(g)){
			System.out.println("Enter hand for each player in the form 'id RankSuit RankSuit RankSuit RankSuit RankSuit'");
			Scanner in = new Scanner(System.in);
			System.out.print("> ");
			String s = in.nextLine();
			int id = Integer.valueOf(s.trim().substring(0, 1));
			if (id > g.players.size()){
				System.out.println("Invalid id - usually 0 - 3 based on number of players");
				continue;
			}
			g.getPlayers().get(id).setHand(s.substring(2).trim());
		}

		List<Player> players = new ArrayList<Player>(g.players);
		Collections.sort(players, Player.getCompByHandRank());
		int i = 1;
		for ( Player p : players){
			System.out.println("Rank " + i + " - Player " + p.getId() + " - " + p.getHandString());
			i++;
		}
	}

	private static boolean playersDontHaveCards(Game g) {
		for (Player p : g.players){
			if(p.getHand() == null)
				return true;
		}		
		return false;
	}

	private static void printPlayerIds(Game g) {
		for (int i=0;i<g.getPlayers().size();i++){
			System.out.println("Player " + (i+1) + " id: " + g.getPlayers().get(i).id);
		}
	}

}
