import java.io.*; 
import java.net.*; 

public class TCPServer {

	public static void main(String[] args)throws Exception {
		String clientSentence;
        String capitalizedSentence; 
        ServerSocket welcomeSocket = null;

        try {
            welcomeSocket = new ServerSocket(8486); 

            while(true) {
                Socket connectionSocket = welcomeSocket.accept(); 

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 

                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 

                clientSentence = inFromClient.readLine();
                capitalizedSentence = clientSentence.toUpperCase() + '\n';
                outToClient.writeBytes(capitalizedSentence);

                connectionSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (welcomeSocket != null && !welcomeSocket.isClosed()) {
                welcomeSocket.close();
            }
        }
	}

}
