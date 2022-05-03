import java.net.*;
import java.io.*;
import java.util.ArrayList;

class ServeurIRC {
    ArrayList<ThreadClient> V;

    public static void main(String args[]) {
        int port = 1973;
        if (args.length == 1)
            port = Integer.parseInt(args[0]);
        new ServeurIRC(port);
    }

    public ServeurIRC(int port) {
        V = new ArrayList<>();
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket clientSocket = server.accept();
                new ThreadClient(clientSocket, this);

            }
        } catch (Exception e) {
            System.err.println(e);

        }
    }

    synchronized public void EnvoyerATous(String s) {
        for (int i = 0; i < V.size(); i++) {
            ThreadClient c = (ThreadClient) V.get(i);
            c.Envoyer(s);
        }
    }

    public void ajouterClient(ThreadClient c) {
        // ... (ajout d un client dans le vecteur V)
        V.add(c);
    }

    synchronized public void EnvoyerListeClients(PrintWriter out) {
        out.println("Liste des clients connectes");
        for (int i = 0; i < V.size(); i++) {
            System.out.println("inside client " + i);
            out.println(i + 1 + ": " + V.get(i).nom);
            out.flush();
        }

    }

    synchronized public void SupprimerClient(ThreadClient c) {
        V.remove(c);
    }

    public void envoyerATous(String s) {
        for (int i = 0; i < V.size(); i++) {
            V.get(i).Envoyer(s);
        }

    }

}