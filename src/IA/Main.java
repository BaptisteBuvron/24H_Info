package IA;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

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

		for (Order order: orders) {
			ArrayList<int[]> path = map.findPath(new Integer[]{livreur.getPosX(), livreur.getPosY()},new Integer[]{order.sourceX,order.sourceY});
			livreur.setPath(path);
			livreur.setOrder(order);
			livreur.goToDeliverLocation();
		}



		/*for (int[] c: path) {
			System.out.println(c[0]+";"+c[1]);
		}*/



//		network.getMap();
	}
}
