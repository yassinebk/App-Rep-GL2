// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

// ClientHandler class
class ClientHandler extends Thread {
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        while (true) {
            try {

                // Ask user what he wants
                dos.writeUTF("What do you want?[Date | Time]..\n" +
                        "Type Exit to terminate connection.");

                // receive the answer from client
                // received = dis.readUTF();
                // System.out.println(received);

                // if (received.equals("Exit")) {
                //     System.out.println("Client " + this.s + " sends exit...");
                //     System.out.println("Closing this connection.");
                //     this.s.close();
                //     System.out.println("Connection closed");
                //     break;
                // }

                 dos.writeUTF("Invalid input");

                // // creating Date object
                // Date date = new Date();

                // // write on output stream based on the
                // // answer from the client
                // switch (received) {

                // case "Date":
                // toreturn = fordate.format(date);
                // dos.writeUTF(toreturn);
                // break;

                // case "Time":
                // toreturn = fortime.format(date);
                // dos.writeUTF(toreturn);
                // break;

                // default:
                // break;
                // }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        
    }
}
