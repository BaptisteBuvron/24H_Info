package IA;

public class Order {
	int id, sourceX, sourceY, destX, destY, value, maxRound;

	public Order(int id, int sourceX, int sourceY, int destX, int destY, int value, int maxRound) {
		this.id = id;
		this.sourceX = sourceX;
		this.sourceY = sourceY;
		this.destX = destX;
		this.destY = destY;
		this.value = value;
		this.maxRound = maxRound;
	}
	
	public void deliver() {
		//send request to deliver order
	}
}
