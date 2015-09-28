import java.util.ArrayList;

public class Game {
	public Game(int p) {
		System.out.println("Welcome to PokerTDD - How many players are present?");
		for (int i=0;i<p;i++){
			players.add(new Player());
		}
		
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	ArrayList<Player> players = new ArrayList<Player>(5);

	public void givePlayerHand(int p, String h) {
		players.get(p).setHand(h);
	}

}
