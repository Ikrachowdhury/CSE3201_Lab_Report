import java.io.*;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket client_socket = new Socket("127.0.0.1",22222);

        ObjectOutputStream oos = new ObjectOutputStream(client_socket.getOutputStream());
        String message = "even";
        oos.writeObject(message);
        try{
            while(true){

                int str;
                BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream client_out = new DataOutputStream(client_socket.getOutputStream());
                BufferedReader server_input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
                System.out.println("Even Client connected..");
                System.out.println("Enter number : ");
                str = Integer.parseInt(user_input.readLine());

                client_out.writeBytes(String.valueOf(str));
                client_socket.close();
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
