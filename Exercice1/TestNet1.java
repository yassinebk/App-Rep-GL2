import java.util.logging.Logger;
import java.util.logging.Level;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestNet1 {

  public static void main(String[] args) {
    try {
      Logger logger = Logger.getLogger(TestNet1.class.getName());
      InetAddress adrLocale = InetAddress.getLocalHost();
      logger.log(Level.INFO, "Adresse locale = {0} ", adrLocale.getHostAddress());
      InetAddress adrServeur = InetAddress.getByName("www.insat.rnu.tn");
      logger.log(Level.INFO, "Adresse Sun = {0}", adrServeur.getHostAddress());
      InetAddress[] adrServeurs = InetAddress.getAllByName("www.facebook.com");
      for (int i = 0; i < adrServeurs.length; i++) {
        logger.log(Level.INFO, "Adresses Facebook  www.facebook.com {0}", adrServeurs[i].getHostAddress());
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

  }
}