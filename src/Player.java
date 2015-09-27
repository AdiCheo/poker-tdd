
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

	public String getHand() {
		return this.playerHand.getHandString();	
	}
}
