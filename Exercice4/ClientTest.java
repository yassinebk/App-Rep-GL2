import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ClientTest {
    public static void main(String[] args) {
        Socket socket;
        BufferedReader bufferedReader;
        PrintWriter printWriter;

        try {
            socket = new Socket(InetAddress.getByName("yassine-belkhadem"), 1973);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());

            printWriter.println("nomyasisne");
            printWriter.flush();
            while (socket.isConnected()) {

                try {
                    System.out.println("here");
                    String messageClient = bufferedReader.readLine();
                    System.out.println("here");
                    System.out.println("Message Client : " + messageClient);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    break;
                }
            }
        } catch (Exception exception) {

        }
    }

}
