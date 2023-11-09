import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost", 4713);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
