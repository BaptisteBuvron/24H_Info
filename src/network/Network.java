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
        init();
    }

    public void init() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = reader.readLine();
        System.out.println(str);
        if (str.equals("NAME")){
            name("LaSekt");
        }
        waitStart();
    }

    public void waitStart() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = reader.readLine();
        System.out.println(str);
    }


    public void move(int nPlayer, String direction) throws IOException {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("MOVE|"+nPlayer+"|"+direction);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = reader.readLine();
        }
    }

    public void name(String name) throws IOException {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println(name);
            writer.close();
        }
    }



}
