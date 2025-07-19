import java.net.Socket;
import java.io.*;

public class clientSide{
    public static void main(String args[]) throws IOException{
        try{
            Socket socket = new Socket("127.0.0.1", 4444);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            InputStream input = socket.getInputStream(); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String clientMessage;
            while((clientMessage = consoleInput.readLine()) != null){
                writer.println(clientMessage);
                String serverResponse = reader.readLine();
                System.out.println("Server responded : " + serverResponse);
            }           
             socket.close();
        }
        catch(Exception e){
            System.out.println("Unable to connect: " + e.getMessage());
        }
    }
}