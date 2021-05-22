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

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", sourceX=" + sourceX +
				", sourceY=" + sourceY +
				", destX=" + destX +
				", destY=" + destY +
				", maxRound=" + maxRound +
				", value=" + value +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSourceX() {
		return sourceX;
	}

	public void setSourceX(int sourceX) {
		this.sourceX = sourceX;
	}

	public int getSourceY() {
		return sourceY;
	}

	public void setSourceY(int sourceY) {
		this.sourceY = sourceY;
	}

	public int getDestX() {
		return destX;
	}

	public void setDestX(int destX) {
		this.destX = destX;
	}

	public int getDestY() {
		return destY;
	}

	public void setDestY(int destY) {
		this.destY = destY;
	}

	public int getMaxRound() {
		return maxRound;
	}

	public void setMaxRound(int maxRound) {
		this.maxRound = maxRound;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}
