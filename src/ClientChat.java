
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {

    static int port = 7777;

    public static void main(String[] args) throws IOException {

        System.out.println("\t\tSimple CLient");
        System.out.println("\t\t==========\n\n");

        Scanner ScannerInput = new Scanner(System.in);
        String input, output;

        InetAddress ipAddress = InetAddress.getLocalHost(); //use try catch

        Socket socket = new Socket(ipAddress, port);

        System.out.println("Server is connected...\n\n");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        try {
            while (true) {
                input = in.readLine();
                System.out.println("Server Says: " + input);

                System.out.println("Client: ");
                output = ScannerInput.next();
                out.println(output);
            }
        } finally {
            socket.close();
            out.close();
            in.close();
        }
    }

}
