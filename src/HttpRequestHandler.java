import java.net.Socket;


public class HttpRequestHandler implements Runnable {
	final static String CRLF = "\r\n";
    Socket socket;
    
    public HttpRequestHandler(Socket socket) throws Exception {
    	this.socket = socket;
    	System.out.println("constructor http");
    }
    
    public void run() {
    	try {
    		System.out.println("HttpRequesthandler");
    		processRequest();
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    /*
     * Gets a request from another node.
     */
    private void processRequest() throws Exception {
    	
    }
}
