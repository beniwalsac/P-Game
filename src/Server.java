import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class Server extends Thread {
	// Display a message, preceded by
    // the name of the current thread
	int connections=0;
    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }
    
    private ServerSocket serverSocket;
    
    public Server(int port) throws IOException {
    	serverSocket = new ServerSocket(port);
    }
    
    public void run() {
    	try {
    		threadMessage("Waiting for client on port " +
                    serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            connections++;
            threadMessage("Just connected to "
                    + server.getRemoteSocketAddress());
            BufferedReader readerChannel = new BufferedReader(new InputStreamReader(server.getInputStream()));
            BufferedWriter writerChannel = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
            
    	} catch(SocketTimeoutException s) {
            threadMessage("Socket timed out!");
    	} catch(IOException e) {
            threadMessage("connection probably lost");
            e.printStackTrace();
        }
    }
    
}
