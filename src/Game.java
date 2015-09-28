import java.util.ArrayList;

public class Game {
	public Game(int p) {
		players = new ArrayList<Player>(4);
		System.out.println("Welcome to PokerTDD - How many players are present?");
		for (int i=0;i<p;i++){
			players.add(new Player());
		}
		
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	ArrayList<Player> players;

	public void givePlayerHand(int p, String h) {
		players.get(p).setHand(h);
	}

}
