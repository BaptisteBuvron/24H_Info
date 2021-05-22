
import IA.Joueur;
import map.Map;
import network.Network;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static int idTeam;
    public static Network network;

    public static void main(String args[]) throws IOException {
        Network network = new Network();
        Map map = new Map();
        network.init();
        idTeam = network.waitStart();
        Joueur ia = new Joueur();
        map.createMap(network.getMap());
        ArrayList<int[]> path = map.findPath(new Integer[]{0, 6},new Integer[]{6,9});


    }
}
