package IA;

import network.Network;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Livreur {

    private Order order;
    private ArrayList<int[]> path;
    int maxIndex = 0;
    private int posX, posY;
    private int id;

    public Livreur(int id, int initX, int initY) {
        posX = initX;
        posY = initY;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Livreur [orders:, posX=" + posX + ", posY=" + posY + "]";
    }

    public int[] getPos() {
        return new int[]{posX, posY};

    }

   /* public int getBagCapacity() {
        return orders.stream().filter(Value -> Value != null).collect(Collectors.toList()).size();

    }

    public Order[] getOrders() {
        return (Order[]) orders.toArray(new Order[orders.size()]);
    }*/

    public void setOrder(Order order) {
        this.order = order;
    }

   /* private void removeOrderFromList(int index) {
        orders.set(index, null);
    }*/

    /*public void deliverOrder(int orderId) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.id == orderId) {
                order.deliver();
                removeOrderFromList(i);
            }
        }
    }*/

    public void goToDeliverLocation() throws IOException, InterruptedException {
		/*for (int i = 0; i < 8; i++) {
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
		}*/


        for (int[] coord : path) {
            String dir = null;
            if (posX > coord[0]) {
                dir = "T";
                posX--;
            } else if (posX < coord[0]) {
                dir = "B";
                posX++;
            } else if (posY > coord[1]) {
                dir = "L";
                posY--;
            } else if (posY < coord[1]) {
                dir = "R";
                posY++;
            }

            if (dir != null) {
                if (Joueur.nbTour < 1) {
                    Main.network.endTurn();
                    Main.network.waitStart();
                    Joueur.nbTour = 8;
                }
                Main.network.move(0, dir);
                Joueur.nbTour--;
            }
        }

        if (Main.network.take(id, order.id).equals("OK")) {
            System.out.println("La commande a été prise");
            /*posX = path.get(path.size() - 2)[0];
            posY = path.get(path.size() - 2)[0];*/
            path = Main.map.findPath(new Integer[]{posX, posY}, new Integer[]{order.destX, order.destY});
            System.out.println("Livrer la commande");
            goToDeliverLocation();

        } else {
            Main.network.deliver(id, order.id);
            System.out.println("Commande livrée !");
            path = null;
        }




    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPath(ArrayList<int[]> path) {
        this.path = path;
    }
}
