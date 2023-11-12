package serveur;
import java.io.IOException;
import rmiservice.IConversion;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class Serveur {
    public static void main(String[] args) {
        try {
            int n;
            System.out.println("je suis en attente");
            ServerSocket s = new ServerSocket(1234);

            Socket socket=s.accept();
            System.out.println(" tapez un nombre");
            System.out.println(" client connecte");

            // Crée une instance du service RMI
            IConversion conversion = (IConversion) java.rmi.Naming.lookup("//localhost:1099/Conversion");
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();
            n=is.read();
            // Convertit un montant en euros
            double montant = n;
            double montantConverti = conversion.convertirMontant(montant);

            // Affiche le résultat de la conversion
            System.out.println("Le montant converti en dollars est de " + montantConverti);
            os.write((int)montantConverti);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}