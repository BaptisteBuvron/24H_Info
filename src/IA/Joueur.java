package IA;

import java.io.IOException;

public class Joueur {

	private Livreur[] livreurs = new Livreur[2];

	public Joueur() throws IOException {
		fetchBikers();
	}

	public void fetchBikers() throws IOException {
		String bikerString = Main.network.getBikers();
		System.out.println(bikerString);
		String biker_1 = bikerString.substring(3, 7);
		String biker_2 = bikerString.substring(9);
		String delimiters = ";";
		// analyzing the string
		String[] biker_1_Pos = biker_1.split(delimiters);
		String[] biker_2_Pos = biker_2.split(delimiters);

		// prints the number of tokens
//		System.out.println("Count of tokens = " + tokensVal.length);

		livreurs[0] = new Livreur(Integer.parseInt(biker_1_Pos[0]), Integer.parseInt(biker_1_Pos[1]));
		livreurs[1] = new Livreur(Integer.parseInt(biker_2_Pos[0]), Integer.parseInt(biker_2_Pos[1]));
////		livreurs[0] = new Livreur(biker_1, 0)v

		for (Livreur livreur : livreurs) {
			System.out.println(livreur);
		}
	}

}
