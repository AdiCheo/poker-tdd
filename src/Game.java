import java.util.ArrayList;

public class Game {
	public Game(){
		System.out.println("Welcome to PokerTDD - How many players are present?");
	}

	public Game(int p) {
		for (int i=0;i<p;i++){
			players.add(new Player());
		}
		
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	ArrayList<Player> players = new ArrayList<Player>(5);

}
