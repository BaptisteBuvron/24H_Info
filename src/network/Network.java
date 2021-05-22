package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Network {

    private Socket socket;

    public Network() throws IOException {
        this.socket = new Socket("127.0.0.1", 2121);
    }

    public void init() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String str = reader.readLine();
        reader.close();
        System.out.println(str);
        if (str.equals("NAME")){
            name("LaSekt");
        }
        waitStart();
    }

    public void waitStart() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String fromServer = reader.readLine();
        reader.close();
        System.out.println(fromServer);
    }


    public void move(int nPlayer, String direction) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("MOVE|"+nPlayer+"|"+direction);
            String str = reader.readLine();
            reader.close();
        }
    }

    public void name(String name) throws IOException {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println(name);
        }
    }



}
