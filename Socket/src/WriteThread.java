import java.io.*;
import java.net.*;

public class WriteThread extends Thread {
    private Socket socket;
    private ChatClient client;
    private PrintWriter writer;

    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;

        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error getting output stream: " + e.getMessage());
        }
    }

    public void run() {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String userName = consoleReader.readLine();
            client.setUserName(userName);
            writer.println(userName);  

            String message;
            while (true) {
                message = consoleReader.readLine();
                writer.println(message);

                if (message.equalsIgnoreCase("bye")) {
                    break;  
                }
            }
            socket.close();

        } catch (IOException ex) {
            System.out.println("Error in WriteThread: " + ex.getMessage());
        }
    }
}
