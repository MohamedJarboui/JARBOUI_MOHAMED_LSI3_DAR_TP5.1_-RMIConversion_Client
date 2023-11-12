package rmiClient;

import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class ConversionClient {
    public static void main(String[] args) throws Exception {
        try {
            int n;
            Scanner scanner= new Scanner(System.in);

            Socket socket=new Socket("localhost",1234);
            System.out.println("je suis connecte");
            System.out.println("je suis connecte");
            System.out.println("le nombre est =  ");
            n=scanner.nextInt();
            OutputStream os=socket.getOutputStream();
            os.write(n);
            InputStream is=socket.getInputStream();
            System.out.println("montantConverti ="+is.read());
        }



        catch (Exception e){
            e.printStackTrace();
        }
    }
}
