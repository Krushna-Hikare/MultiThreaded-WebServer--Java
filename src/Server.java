import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Server {
    public Consumer<Socket>  getConsumer() {
        return (clientSocket) -> {
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                BufferedReader fromClient= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                toClient.println("Hello from the server"+" "+clientSocket.getInetAddress());
                toClient.flush();

                System.out.println(fromClient.readLine());
                toClient.close();
                fromClient.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
    public void run() {
            int port=8010;
        try{

            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port "+port);
            while(true){
                Socket acceptedSocket = serverSocket.accept();
                Thread thread= new Thread(()->this.getConsumer().accept(acceptedSocket));
                thread.start();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
    public static void main(String[] args) {
        Server s= new Server();
        s.run();
    }
}