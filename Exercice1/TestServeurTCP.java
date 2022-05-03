import java.net.*;
import java.io.*;

public class TestServeurTCP {
  final static int port =9100;

  public static void main(String[] args) {
    try {
      ServerSocket socketServeur = new ServerSocket(port);
      System.out.println("Lancement du serveur");
      InetAddress adrLocale = InetAddress.getLocalHost();
      String Nom = adrLocale.getHostName();
      System.out.println("Connexion avec" + Nom);
      while (true) {
        Socket socketClient = socketServeur.accept();
        String message = "";

        System.out.println("Connexion avec : " + socketClient.getInetAddress());

        // InputStream in = socketClient.getInputStream();
        // OutputStream out = socketClient.getOutputStream();

       
  
        socketClient.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}