import java.awt.BorderLayout;
import java.net.InetAddress;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientFenetre extends Frame implements Runnable, ActionListener {
    TextArea Output;
    TextField Input;

    Socket socket = null;
    BufferedReader in;
    PrintWriter out;

    /**
     * 
     */
    public ClientFenetre(InetAddress host, int port) {
        super("Client en fenetre");

        // mise en forme de la fentre
        this.setSize(500, 700);

        this.setLayout(new BorderLayout());

        add(Output = new TextArea(), BorderLayout.CENTER);
        Output.setEditable(false);
        add(Input = new TextField(), BorderLayout.CENTER);
        Input.setEditable(false);

        pack();
        show();
        Input.requestFocus();

        // ajout d'un window adpter
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        // ouvrir connexion + hote;
        InetAddress serveur = InetAddress.getByName(args[0]);
        socket = new Socket(serveur, port);
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        int reqCount = 0;
        // reception des message et les afficher dans text area
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Input) {
            String phrase = Input.getText();
            out.println(phrase);
            out.flush();
            Input.setText("");
        }
    }

    public void finalize() {
        socket.close();
    }

    public static void main(String[] args) {
        InetAddress hote = null;
        int port = 1973;
        Socket socket = null;
        

    }
}
