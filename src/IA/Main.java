package IA;

import java.io.IOException;

import network.Network;

public class Main {

	public static int idTeam;
	public static Network network;

	public static void main(String args[]) throws IOException, InterruptedException {
		network = new Network();
		network.init();
		idTeam = network.waitStart();
		Thread.sleep(1000);
		Joueur ia = new Joueur();
//		network.getMap();
	}
}
