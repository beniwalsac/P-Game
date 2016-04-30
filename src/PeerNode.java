import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class PeerNode {
	private int port;
	private ArrayList<PeerNode> contacts;
	PeerNode preNode,postNode;
	
	public PeerNode(int port) {
		this.port = port;
		new Thread(new Runnable() {
			public void run() {
				startClientServer(port);
			}
		}).start();
	}
	
	private void sendRequest(String name, String host, int port) throws UnknownHostException, IOException {
		Socket socket = new Socket(host, port);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		out.println(name);
		
		out.close();
		socket.close();
	}
	
	private void startClientServer(int port) {
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(0);
			System.out.println("listening on port " + server.getLocalPort());
			
			while(true) {
				//Listen for TCP request
				System.out.println("Loop initialisation");
				Socket connection = server.accept();
				System.out.println("connection established");
                HttpRequestHandler request = new HttpRequestHandler( connection );
                System.out.println("Thread initialisation");
                Thread thread = new Thread(request);
                thread.start();
                System.out.println("Thread started for "+ port);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
