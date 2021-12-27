import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClinetTow {
    public static void main(String[] args)throws Exception {
        Socket server = new Socket(InetAddress.getLocalHost(),4000);
        DataInputStream input  = new DataInputStream(server.getInputStream());
        DataOutputStream output = new DataOutputStream(server.getOutputStream());
        Scanner write = new Scanner(System.in);
        String msg  = "" ;
        System.out.println(input.readUTF());
        do {
            msg = write.nextLine();
            output.writeUTF(msg);
            System.out.println(input.readUTF());
        } while (!msg.equals("Stop"));
    }
}
