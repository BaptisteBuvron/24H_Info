package IA;

import network.Network;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static IA.Main.ia;

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
            System.out.println("Déplacement : "+coord[0]+";"+coord[1]);
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
                checkTour();
                Main.network.move(0, dir);
                Joueur.nbTour--;
            }
        }
        checkTour();
        if (Main.network.take(id, order.id).equals("OK")) {
            Joueur.nbTour--;
            System.out.println("La commande a été prise");
            /*posX = path.get(path.size() - 2)[0];
            posY = path.get(path.size() - 2)[0];*/
            path = Main.map.findPath2(new Integer[]{posX, posY}, new Integer[]{order.destX, order.destY});
            System.out.println("Livrer la commande chez le client");
            goToDeliverLocation();


        } else {
            Main.network.deliver(id, order.id);
            Joueur.nbTour--;
            System.out.println("Commande livrée !");
            path = null;
        }



        Order[] orders = ia.getClaimableOrders();

        System.out.println(orders[0]);

        Livreur livreur = ia.getLivreurs(0);
        ArrayList<ArrayList<int[]>> allPath = new ArrayList<>();

        for (Order order: orders) {
            ArrayList<int[]> path = Main.map.findPath2(new Integer[]{livreur.getPosX(), livreur.getPosY()},new Integer[]{order.sourceX,order.sourceY});
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




    }

    public void checkTour() throws IOException {
        if (Joueur.nbTour < 1) {
            Main.network.endTurn();
            Main.network.waitStart();
            Joueur.nbTour = 8;
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
