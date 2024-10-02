import java.io.*;
import java.net.*;

public class ReadThread extends Thread {
    private Socket socket;
    private ChatClient client;

    public ReadThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String response;

            while ((response = reader.readLine()) != null) {
                System.out.println(response);
            }

        } catch (IOException ex) {
            System.out.println("Error in ReadThread: " + ex.getMessage());
        }
    }
}
