import java.util.Comparator;

public class Player {

	int id;
	Hand playerHand;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setHand(String playerHand) {
		this.playerHand = new Hand(playerHand);
	}

	public int[] getHandRank() {
		return this.playerHand.getHandRank();	
	}

	public String getHandString() {
		return this.playerHand.getHandString();	
	}

	public Hand getHand() {
		return this.playerHand;	
	}

	public static Comparator<Player> getCompByHandRank() {
		Comparator<Player> comp = new Comparator<Player>() {
			@Override
			public int compare(Player s1, Player s2) {
				if (s2.getHandRank()[0] == s1.getHandRank()[0]){
					return s2.getHandRank()[1] - s1.getHandRank()[1];
				}
				return s2.getHandRank()[0] - s1.getHandRank()[0];
			}
		};
		return comp;
	}
}
