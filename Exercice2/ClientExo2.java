import java.net.*;
import java.io.*;

public class ClientExo2 {
    final static int port = 9100;

    public static void main(String[] args) {
        Socket socket;
        // DataInputStream userInput;
        // PrintStream theOutputStream;
        int reqCount = 0;
        try {

            InetAddress serveur = InetAddress.getByName(args[0]);
            socket = new Socket(serveur, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println(args[0]);
            System.out.println(in.readLine());

            if (socket.isConnected()) {
                while (reqCount < 5) {
                    reqCount++;
                    String incomingMessage = in.readLine();
                    System.out.println("Incoming Message " + incomingMessage);
                    out.println("Merci");
                    out.flush();
                    if (socket.isClosed())
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}