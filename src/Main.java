
import map.Map;
import network.Network;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        Network network = new Network();
        Map map = new Map();
        network.init();
        int idTeam = network.waitStart();
        map.createMap(network.getMap());
        map.findPath(new Integer[]{0, 6},new Integer[]{6,9});
    }
}
