
package ss.week7.cmdline;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
      if (args.length != 2) {
        System.out.println(USAGE);
        System.exit(0);
      }
      
      String name = args[0];
      int port = 0;
      Socket sock = null;
      
      // parse args[1] - the port
      try {
          port = Integer.parseInt(args[1]);
      } catch (NumberFormatException e) {
          System.out.println(USAGE);
          System.out.println("ERROR: port " + args[1]
                             + " is not an integer");
          System.exit(0);
      }
      
      // establish server socket
      try {
        ServerSocket s = new ServerSocket(port);
        System.out.print("Listening to " + port + "\n");
        sock = s.accept(); // wait for client connection
        System.out.print("Connected \n");
        Peer peer = new Peer(name, sock);
        
        
        Thread streamInputHandler = new Thread(peer);
        streamInputHandler.start();
        peer.handleTerminalInput();
        peer.shutDown();
        
        
       
      } catch (IOException e) {
        e.printStackTrace();
      }
      
    }
    

} // end of class Server
