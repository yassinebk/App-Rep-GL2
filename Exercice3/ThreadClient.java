import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClient extends Thread {
    private Socket socket = null;
    public int clientNo;
    public int reqcount = 0;
    PrintWriter out;
    BufferedReader in;

    public ThreadClient(Socket socket, int no) {
        super("ThreadClient");
        this.socket = socket;
        this.clientNo = no;
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    private String message_suivant() {
        reqcount++;
        switch (reqcount % 5) {
            case 0:
                return new String("Marrakech est une ville magnifique");
            case 1:
                return new String("La medina de Fes est splendide au couchant");
            case 2:
                return new String("Les montages de L'atlas sont impressionants");
            default:
                return new String("i RAN OUT OF IDEAS");
        }

    }

    void FaireUnePause(int millis) {
        try {
            System.out.println("Pause d'une seconde");
            Thread.currentThread().sleep(millis);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    public void run() {
        out.println("Bonjour Client " + this.clientNo);
        out.flush();
        while (socket.isConnected()) {
            System.out.println("here");
            try {
                String messageClient = in.readLine();
                System.out.println("Message Client : " + messageClient);
                
                // FaireUnePause(1000);
                // out.println(message_suivant());
                // out.flush();
            } catch (Exception exception) {
                // exception.printStackTrace(out);
                // System.out.println("Error happened in running thread for client " +
                // this.clientNo);
                break;
            }
        }
    }

    protected void finalize() throws IOException {
        this.socket.close();
    }

}