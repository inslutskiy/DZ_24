import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String... args) throws IOException {
        int port = 8989;
        String game = null;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Сервер запущен!");

            while (true) {
                try (Socket client = server.accept();
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                    if (game == null) {
                        System.out.println("???");
                        game = reader.readLine();
                        System.out.println("OK");
                    } else {
                        System.out.println(game);
                        String x = reader.readLine();
                        if (game.charAt(game.length() - 1) == x.charAt(0)) {
                            game = x;
                            System.out.println("OK");
                        } else {
                            System.out.println("NOT OK");
                        }
                    }
                }
            }
        }
    }
}