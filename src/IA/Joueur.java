package IA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Joueur {

	private ArrayList<Livreur> livreurs = new ArrayList<>();
	public static int nbTour = 8;

	public Joueur() throws IOException {
		fetchBikers();
	}

	public void fetchBikers() throws IOException {
		String bikerString = Main.network.getBikers();
		System.out.println(bikerString);
		String[] bikersPos = bikerString.substring(3).split("\\|");
		String biker_1 = bikersPos[0];

		System.out.println(biker_1);
		String biker_2 = bikersPos[1];
		System.out.println(biker_2);
		String delimiters = ";";
		// analyzing the string
		String[] biker_1_Pos = biker_1.split(delimiters);
		String[] biker_2_Pos = biker_2.split(delimiters);
		System.out.println(Arrays.toString(biker_1_Pos)+ ":"+Arrays.toString(biker_2_Pos));

		System.out.println("OK");
		System.out.println(Integer.parseInt(biker_1_Pos[1]));
		System.out.println(biker_1_Pos[2]);
		livreurs.add(new Livreur(0,Integer.parseInt(biker_1_Pos[1]), Integer.parseInt(biker_1_Pos[2])));
		livreurs.add(new Livreur(1,Integer.parseInt(biker_2_Pos[1]), Integer.parseInt(biker_2_Pos[2])));

		for (Livreur livreur : livreurs) {
			System.out.println(livreur);
		}
	}

	
	public Order[] getClaimableOrders() throws IOException {
		return Main.network.getOrders();
	}

	public Livreur getLivreurs(int i) {
		return livreurs.get(i);
	}
}
