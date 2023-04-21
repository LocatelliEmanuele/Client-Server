import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server implements Runnable {

    private final Socket Client;
    public Server(Socket client){Client = client;}

    @Override
    public void run() {
        try {
            System.out.println("[Connesso al client]");
            PrintWriter writer = new PrintWriter(Client.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(Client.getInputStream()));

            while (true) {
                String string = reader.readLine();
                System.out.printf("\n[Ricevuto %s]", string);

                BufferedReader temperatura = new BufferedReader("src\\",string,"temperatura.txt",true);

                writer.print(string.toUpperCase() + "\n");
                writer.flush();
                //client.close();
            }
        }catch (Exception e){
            System.out.printf("/!\\ Hai sbagliato qualcosa: [ %s ] /!\\\n",e.getMessage());
        }
    }

}