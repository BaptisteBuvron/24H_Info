package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
        if (str.equals("NAME")){
            name("LaSekt");
        }
    }

    public int waitStart() throws IOException {
        String fromServer = reader.readLine();
        System.out.println(fromServer);
        return Integer.parseInt(fromServer.substring(fromServer.length() -1));

    }


    public void move(int nPlayer, String direction) throws IOException {

        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("MOVE|"+nPlayer+"|"+direction);
            String str = reader.readLine();
            reader.close();
        }
    }

    public void name(String name) throws IOException {
        writer.println(name);
    }



}
