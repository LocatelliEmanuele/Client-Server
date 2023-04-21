import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.net.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(System.currentTimeMillis());
        try {

            Socket clientSocket = new Socket("localhost", 5000);
            System.out.println("server contattato");
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String temperatura;
            while (true) {

                System.out.println("INSERIRE TEMPERATURA");
                temperatura = sc.nextLine();
                writer.println(System.currentTimeMillis() + ":" + temperatura);
                writer.flush();
                System.out.println("temperatura media : " + reader.readLine());
            }

        } catch (Exception e) {

            System.out.println("eccezione " + e.getMessage());

        }
    }
}