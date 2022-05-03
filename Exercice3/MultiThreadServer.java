// package Exercice2;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
    final static int port = 9100;
    static int client = 0;

    public static void main(String[] args) {
        try {
            ServerSocket socketServeur = new ServerSocket(port);
            System.out.println("Lancement du serveur");
            InetAddress adrLocale = InetAddress.getLocalHost();
            String Nom = adrLocale.getHostName();
            System.out.println("Connexion avec" + Nom);
            while (true) {
                Socket socketClient = socketServeur.accept();
                ThreadClient tClient = new ThreadClient(socketClient, client);
                tClient.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}