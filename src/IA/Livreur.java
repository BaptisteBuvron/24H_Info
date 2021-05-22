package IA;

public class Livreur {

	private Order[] orders = new Order[2];
	int maxIndex = 0;

	public Livreur() {

	}

	public int[] getPos() {
		return null;

	}

	public int[] getBag() {
		return null;

	}

	public Order[] getOrders() {
		return orders;
	}

	public void addOrder(int id, int sourceX, int sourceY, int destX, int destY, int value, int maxRound) {
		Order tempOrder = new Order(id, sourceX, sourceY, destX, destY, value, maxRound);
		orders[maxIndex++] = tempOrder;
	}

	private void removeOrderFromList(int index) {
		orders[index] = null;
		for (int i = index; i < orders.length; i++) {
			orders[i] = i + 1 >= orders.length ? null : orders[i + 1];
		}
	}

	public void deliverOrder(int orderId) {
		for (int i = 0; i < orders.length; i++) {
			Order order = orders[i];
			if (order.id == orderId) {
				order.deliver();
				removeOrderFromList(i);
			}
		}
	}
	
	public String thisIsTheWay(Order order) {
		//TODO : find nearest path to where we need to pick/deliver the order
		
		
		return null;
	}
}
