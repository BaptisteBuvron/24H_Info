package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import IA.Main;
import IA.Order;

public class Network {

	private Socket socket;

	private BufferedReader reader;
	private InputStreamReader streamReader;
	private PrintWriter writer;

	public Network() throws IOException {
		this.socket = new Socket("127.0.0.1", 2121);
		streamReader = new InputStreamReader(socket.getInputStream());
		reader = new BufferedReader(streamReader);
		writer = new PrintWriter(socket.getOutputStream(), true);
	}

	public void init() throws IOException {
		String str = reader.readLine();
		System.out.println(str);
		if (str.equals("NAME")) {
			name("LaSekt");
		}
	}

	public int waitStart() throws IOException {
		String fromServer = reader.readLine();
//        System.out.println(fromServer);
		return Integer.parseInt(fromServer.substring(fromServer.length() - 1));
	}

	public void move(int nPlayer, String direction) throws IOException {

		writer.println("MOVE|" + nPlayer + "|" + direction);
		reader.readLine();

	}

	public void name(String name) throws IOException {
		writer.println(name);
	}

	public void getMap() throws IOException {
		writer.println("GETMAP");
		String str = reader.readLine();
		System.out.println(str);
	}

	public String getBikers() throws IOException {
		writer.println("GETBIKERS|" + Main.idTeam);
		String str = reader.readLine();
//		System.out.println("Debug : " + str);
		return str;
	}

	public Order[] getOrders() throws IOException {
		writer.println("GETDELIVERIES|");
		String str = reader.readLine();
		System.out.println("Debug : " + str);
		str = str.substring(3);
		String[] allOrders = str.split("\\|");
		Order[] toReturn = new Order[allOrders.length];
		int i = 0;
		for (String order : allOrders) {
			String[] splitedOrder = order.split(";");
			System.out.println(order);
			toReturn[i++] = new Order(Integer.parseInt(splitedOrder[0]), Float.parseFloat(splitedOrder[1]),
					Integer.parseInt(splitedOrder[2]), Integer.parseInt(splitedOrder[3]),
					Integer.parseInt(splitedOrder[4]), Integer.parseInt(splitedOrder[5]),
					Integer.parseInt(splitedOrder[6]));
		}
//		System.out.println(Arrays.toString(toReturn));
		return toReturn;

	}

}
