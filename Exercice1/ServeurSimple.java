import java.io.*;
import java.net.*;

class ServeurSimple {
    public static void main(String[] args) {

        int port = 1973;
        int client = 0;

        if (args.length == 1)
            port = Integer.parseInt(args[0]);
        try ( // 5 personnes en attente maxi
                ServerSocket socketServeur = new ServerSocket(port, 5);) {

            System.out.println("Serveur à l'écoute sur le port :" + port);
            while (true) {
                try (Socket mySocket = socketServeur.accept()) {
                    client++; // un client s'est connecté
                    System.out.println("Client numbero " + client);
                    DataInputStream dis = new DataInputStream(mySocket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(mySocket.getOutputStream());
                    while (true) {
                        ClientHandler clientHandler = new ClientHandler(mySocket, dis, dos);
                        clientHandler.start();

                    }

                }

                catch (IOException e) {
                    System.err.println("Erreur : " + e);
                }

            }
        } catch (IOException e) {
            System.err.println("Impossible de créer un ServerSocket");
        }

    }

}