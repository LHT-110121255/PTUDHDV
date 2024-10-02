import java.net.*;
import java.io.*;

public class MarthServer {
    public static String giaiPT2(int a, int b, int c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            return "Phương trình vô nghiệm";
        } else if (delta == 0) {
            double x = -b / (2.0 * a);
            return "Phương trình có nghiệm kép: x = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Phương trình có hai nghiệm: x1 = " + x1 + ", x2 = " + x2;
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5002);
            System.out.println("Server đang chờ kết nối...");

            Socket socket = serverSocket.accept();
            System.out.println("Đã kết nối với Client");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            int a = input.readInt();
            int b = input.readInt();
            int c = input.readInt();

            int sum = a + b;
            output.writeInt(sum);

            String result = giaiPT2(a, b, c);
            output.writeUTF(result);

            input.close();
            output.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
