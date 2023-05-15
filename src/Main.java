import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static final String HOST = "localhost";
    private static final int PORT = 8989;
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
        {
            String game = reader.readLine();
            System.out.println(game);

            Scanner scanner = new Scanner(System.in);
            String x = scanner.next();
            System.out.println(x);

            String y = reader.readLine();
            System.out.println(y);
        }
    }
}