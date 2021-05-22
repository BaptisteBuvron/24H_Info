package IA;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class Livreur {

	private ArrayList<Order> orders = new ArrayList<Order>(2);
	int maxIndex = 0;
	private int posX, posY;

	public Livreur(int initX, int initY) {
		posX = initX;
		posY = initY;
	}

	@Override
	public String toString() {
		return "Livreur [orders:" + getBagCapacity()
				+ ", posX=" + posX + ", posY=" + posY + "]";
	}

	public int[] getPos() {
		return new int[] {posX, posY};

	}

	public int getBagCapacity() {
		return orders.stream().filter(Value -> Value != null).collect(Collectors.toList()).size();

	}

	public Order[] getOrders() {
		return (Order[]) orders.toArray(new Order[orders.size()]);
	}

	public void addOrder(int id, int sourceX, int sourceY, int destX, int destY, int value, int maxRound) {
		Order tempOrder = new Order(id, sourceX, sourceY, destX, destY, value, maxRound);
		orders.set(maxIndex, tempOrder);
	}

	private void removeOrderFromList(int index) {
		orders.set(index, null);
	}

	public void deliverOrder(int orderId) {
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			if (order.id == orderId) {
				order.deliver();
				removeOrderFromList(i);
			}
		}
	}

	public String thisIsTheWay(Order order) {
		// TODO : find nearest path to where we need to pick/deliver the order

		return null;
	}
}
