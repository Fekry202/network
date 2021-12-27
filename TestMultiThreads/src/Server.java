import java.io.*;
import java.net.ServerSocket;
import java.net.*;
public class Server {
    static Socket server ;
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(4000);
        do {
            server = s.accept();
            ClientHendler t1 = new ClientHendler(server);
            t1.start();
        } while(true);
    }
}
class ClientHendler extends Thread {
    Socket server ;
    DataInputStream input ;
    DataOutputStream output;
    ClientHendler(Socket s) throws Exception{
        server = s ;
        input = new DataInputStream(server.getInputStream());
        output = new DataOutputStream(server.getOutputStream());
    }
    @Override
    public void run() {
        try {
            String Message = "";
            output.writeUTF("You Are Connect ? Enter Yuor Message");
            do {
                Message = input.readUTF();
                output.writeUTF("Echo : "+Message);
            } while (!Message.equals("Stop"));
            input.close();
            output.close();
            server.close();
        } catch (Exception e) {}
    }
}
