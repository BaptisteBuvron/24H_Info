package IA;

import java.io.IOException;
import java.util.ArrayList;

import map.Map;
import network.Network;

public class Main {

	public static int idTeam;
	public static Network network;
	public static Joueur ia;
	public static Map map;


	public static void main(String args[]) throws IOException, InterruptedException {
		network = new Network();
		network.init();
		idTeam = network.waitStart();
		map = new Map();
		map.createMap(network.getMap());
		Thread.sleep(1000);
		ia = new Joueur();



		Order[] orders = ia.getClaimableOrders();

		System.out.println(orders[0]);

		Livreur livreur = ia.getLivreurs(0);
		ArrayList<ArrayList<int[]>> allPath = new ArrayList<>();

		for (Order order: orders) {
			ArrayList<int[]> path = map.findPath2(new Integer[]{livreur.getPosX(), livreur.getPosY()},new Integer[]{order.sourceX,order.sourceY});
			allPath.add(path);
		}

		int i =0;
		Integer len = null;
		int orderInt = 0;
		for (ArrayList<int[]> path:allPath) {
			if (len == null){
				len = path.size();
			}
			else if (path.size()< len){
				len = path.size();
				orderInt = i;
			}
			i++;

		}

		livreur.setOrder(orders[orderInt]);
		livreur.setPath(allPath.get(orderInt));
		livreur.goToDeliverLocation();



		/*for (int[] c: path) {
			System.out.println(c[0]+";"+c[1]);
		}*/



//		network.getMap();
	}
}
