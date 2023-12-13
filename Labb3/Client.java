import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
        
        try {
            // localhost är alias för IP-adress för den lokala datorn d.v.s. den datorn 
            // du kör detta program (vilket i detta fall är samma dator som serverprogrammet körs på)
            Socket socket = new Socket("localhost",4713);
            Scanner scanner = new Scanner(System.in);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter ut = new PrintWriter(socket.getOutputStream());

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            ut.println(name);
            ut.flush();

            System.out.println(in.readLine());
            
            while (true){
                System.out.println("skriv nåt till servern: ");
                String input = scanner.nextLine();
                ut.println(input);
                ut.flush();
                String move = in.readLine();
                System.out.println(move);
            }
    }
    catch (IOException e){
        System.out.println("Ingen Anslutning");
    }
    }
}