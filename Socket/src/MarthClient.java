import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MarthClient {
	public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5002);

            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Nhập số thứ nhất (a): ");
            int a = scanner.nextInt();
            System.out.println("Nhập số thứ hai (b): ");
            int b = scanner.nextInt();
            System.out.println("Nhập số thứ ba (c): ");
            int c = scanner.nextInt();
            
            output.writeInt(a);
            output.writeInt(b);
            output.writeInt(c);

            int sum = input.readInt();
            String equationResult = input.readUTF();

            System.out.println("Tổng hai số a và b là: " + sum);
            System.out.println("Kết quả phương trình bậc hai: " + equationResult);

            scanner.close();
            input.close();
            output.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
