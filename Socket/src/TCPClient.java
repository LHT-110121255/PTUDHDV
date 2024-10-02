import java.io.*; 
import java.net.*; 

public class TCPClient {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String sentence; 
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 8486);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer =  new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 

		System.out.println("Nhap vao: ");
		sentence = inFromUser.readLine(); 
		
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close(); 
	}

}
