
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WindowResHandler extends Thread {

    BufferedReader in;
    TextArea output;
    String name;
    Socket socket;

    WindowResHandler(BufferedReader in, TextArea output, Socket socket, String name) {

        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.output = output;
            this.socket = socket;
            this.name = name;
        } catch (Exception exception) {

        }

    }

    @Override
    public void run() {
        try {
            String newInput;
            System.out.println("here inside wr" + name);

            while (socket.isConnected() && !socket.isClosed()) {
                System.out.println("here inside wr" + in.ready());
                if ((newInput = in.readLine()) != null) {
                    System.out.println("here, WR " + newInput);
                    String currentText = this.output.getText();
                    output.setText(currentText + "\n" + newInput);
                    System.out.println("here");
                }
            }
        } catch (IOException exception) {
            System.out.println("Bye, WR");
            exception.printStackTrace();
        }

    }

}
