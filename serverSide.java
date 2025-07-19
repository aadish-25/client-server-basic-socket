import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class serverSide{
    public static void main(String args[]) throws IOException{

        // Create a server socket that listens on the specified port
        ServerSocket serversocket = new ServerSocket(4444);
        System.out.println("Established server socket, ready to listen");

        // Once the serversocket find a client on the port, it accepts it and creates
        // a new "socket" to communicate the with socket it just accepted 
        Socket socket = serversocket.accept();
        System.out.println("Client connected");

        // Now we create a inputstream for the "socket" we newly created, to accept whatver data is coming
        // and convert that data into characters from raw bytes
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        // Now the srver will send some response, so for that we create a output stream and print wirter object
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);

        // Now we keep on reading the client input till it is null
        String clientMessage;
        while((clientMessage = reader.readLine()) != null){
            System.out.println("CLient says : " + clientMessage);
            writer.println("Hello Client, I got your message!"); 
        }      

        // ONce the input is null, we close both the sockets and exit
        socket.close();
        serversocket.close();
    }
}