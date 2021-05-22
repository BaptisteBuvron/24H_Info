package IA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Livreur {

	private ArrayList<Order> orders = new ArrayList<Order>(2);
	private ArrayList<int[]> path = new ArrayList<int[]>(2);
	int maxIndex = 0;
	private int posX, posY;

	public Livreur(int initX, int initY) {
		posX = initX;
		posY = initY;
		path.set(0, null);
	}

	@Override
	public String toString() {
		return "Livreur [orders:" + getBagCapacity() + ", posX=" + posX + ", posY=" + posY + "]";
	}

	public int[] getPos() {
		return new int[] { posX, posY };

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

	public void goToDeliverLocation(Order order) throws IOException {
		if (path.get(0) == null) {
			// TODO : findPath();
		}
		for (int i = 0; i < 8; i++) {
			String dir = null;
			if (path.get(0)[0] > posX) {
				dir = "T";
			} else if (path.get(0)[0] < posX) {
				dir = "B";
			} else if (path.get(1)[0] < posY) {
				dir = "L";
			} else if (path.get(1)[0] < posY) {
				dir = "R";
			}
			if (dir != null) {

				Main.network.move(0, dir);
			} else {
				throw new Error("Aucune Direction pour le mouvement");
			}
		}
	}
}
