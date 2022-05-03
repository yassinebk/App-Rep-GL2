import java.io.*;
import java.net.*;

class ThreadClient extends Thread {
    BufferedReader In;
    PrintWriter Out;
    ServeurIRC serveur;
    String nom = null;
    Socket socket;

    public ThreadClient(Socket socket, ServeurIRC s) {
        // ... (initialisation des propri t s)
        try {
            Out = new PrintWriter(socket.getOutputStream());
            In = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.socket = socket;
            this.serveur = s;
            System.out.println("new client connected");
            this.start();
        } catch (IOException exception) {
            System.out.println("Error connecting client");
        }
    }

    public void run() {
        System.out.println("here begin of run");

        try {
            while (!socket.isClosed()) {

                // Out.println("hello");
                Out.flush();
                // System.out.println(Out.checkError());
                // System.out.println(socket.isClosed());
                String message;
                // System.out.println("here inside of loop");
                if (In.ready() && (message = In.readLine()) != null)
                    if (nom == null) {
                        String firstReceivedString = message;
                        System.out.println(firstReceivedString);
                        if (firstReceivedString.contains("nom")) {
                            this.nom = firstReceivedString.substring(3 + firstReceivedString.lastIndexOf("nom", 0));
                            System.out.println("client name set to " + nom);
                            this.serveur.EnvoyerListeClients(Out);
                            this.serveur.ajouterClient(this);
                            this.serveur.EnvoyerATous("Nouveau utilisateur connecte" + nom);
                        }
                    } else {

                        System.out.println(message);
                        if (message.equals("bye")) {
                            Envoyer("Bye");

                            socket.close();

                        }
                        // System.out.println(receivedMessage);
                        this.serveur.envoyerATous(nom + ":" + message);
                    }
            }

            serveur.SupprimerClient(this);
            // ... (boucle principale. Utiliser EnvoyerATous())
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("here ioE error");
        } finally {
            serveur.SupprimerClient(this);
        }
        serveur.envoyerATous(this.nom + " a deconnecte");
        System.out.println("Bye client");
    }

    public void Envoyer(String s) // Envoie vers le client
    {
        Out.println(s);
        Out.flush();
    }

    public String nom() {
        return nom;
    }
}
