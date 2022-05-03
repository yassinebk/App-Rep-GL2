import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.print.attribute.standard.MediaSize.NA;

public class ClientFenetre extends Frame {
    private TextArea Output = null;
    private TextField Input = null;
    private TextField NameFieldInput = null;
    private TextField NameField = null;

    private Socket socket = null;
    private BufferedReader in;
    private PrintWriter out;

    private String name = null;
    private int port;
    private String clientAddress;
    private WindowResHandler wr = null;

    Button setNameBtn;
    Button connectBtn;

    /**
     * 
     */
    public ClientFenetre(InetAddress host, int port, String clientAddress) {
        super("Client en fenetre");
        // mise en forme de la fentre
        this.setSize(500, 700);
        this.setResizable(false);
        this.port = port;
        this.clientAddress = clientAddress;
        Output = new TextArea();
        Output.setSize(500, 400);
        Output.setEditable(false);
        Input = new TextField();
        Input.setSize(500, 200);
        Input.setEditable(true);
        NameFieldInput = new TextField("");
        NameField = new TextField("please set your name");
        NameFieldInput.setEditable(true);
        setNameBtn = new Button("set name");
        connectBtn = new Button("connect");

        this.setLayout(new GridLayout(5, 1));

        // ajout d'un window adpter
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        setNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                setName(NameFieldInput.getText());
                NameFieldInput.setText("");
                NameField.setText(name);
            }
        });

        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(NameField);
                remove(NameFieldInput);
                remove(setNameBtn);
                remove(connectBtn);
                // TODO Auto-generated method stub

                try {
                    InetAddress serveur = InetAddress.getByName(clientAddress);
                    socket = new Socket(serveur, port);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("nom" + name);
                    out.flush();
                    wr = new WindowResHandler(in, Output, socket, name);
                    wr.start();
                    if (name != "")
                        showMainView();

                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }
        });
        showInitialView();
        this.setVisible(true);

    }

    void showMainView() {
        // this.setVisible(false);
        add(Output);

        // add(new Text("Insert your message here"));
        add(Input);

        Button btn = new Button("Send Message");
        btn.setSize(100, 100);
        add(btn, BorderLayout.SOUTH);
        Button exitButton = new Button("Exit");

        add(exitButton);

        Input.requestFocus();
        Input.addKeyListener(new KeyListener() {
            // Sample 11: Set the Control Key Status
            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                int KeyCode = e.getKeyCode();
                if (KeyCode == KeyEvent.VK_ENTER) {

                    String phrase = Input.getText();
                    out.println(phrase);
                    out.flush();
                    Input.setText("");
                }
            }

        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.out.println("keyboard");
                String phrase = Input.getText();
                out.println(phrase);
                out.flush();
                Input.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText("");
                remove(Input);
                remove(Output);
                remove(exitButton);
                remove(btn);
                showInitialView();
                try {
                    out.print("bye");
                    out.flush();
                    out.close();
                    in.close();
                    socket.close();
                    System.out.println("socket closed " + socket.isClosed());
                } catch (IOException exception) {
                    exception.printStackTrace();
                    System.out.println("here");
                }
            }
        });

        this.setVisible(true);

    }

    void showInitialView() {
        this.add(NameFieldInput);
        this.add(NameField);
        this.add(setNameBtn);
        this.add(connectBtn);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void finalize() {
        try {
            socket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InetAddress hote = null;
        int port = 1973;
        Socket socket = null;
        ClientFenetre chatwindow = new ClientFenetre(hote, port, args[0]);

    }
}
