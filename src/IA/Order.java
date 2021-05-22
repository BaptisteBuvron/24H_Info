package IA;

public class Order {
	int id, sourceX, sourceY, destX, destY, maxRound;
	float value;

	public Order(int id, float f, int sourceX, int sourceY, int destX, int destY, int maxRound) {
		this.id = id;
		this.sourceX = sourceX;
		this.sourceY = sourceY;
		this.destX = destX;
		this.destY = destY;
		this.value = f;
		this.maxRound = maxRound;
	}

	public void deliver() {
		// send request to deliver order
	}
}
