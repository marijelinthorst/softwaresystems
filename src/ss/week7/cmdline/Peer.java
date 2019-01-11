package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException {
      name = nameArg;
      sock = sockArg;
      
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
      boolean loop = true;
      try {
        InputStream inStream = sock.getInputStream();
        in = new BufferedReader (new InputStreamReader(inStream));
        while (loop) {
          String line =  in.readLine();
          System.out.println(line);
          if (line == null || line.equals(EXIT)) { 
            loop = false;
            this.shutDown();
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
      try {
        out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        String termInput = "Begin";
        while (termInput!=null) {
          termInput = readString();
          out.write(termInput);
          out.newLine();
          out.flush();
          if (termInput.equals(EXIT)){
            System.out.println("Exiting");
            out.write("Exiting");
            termInput=null;
            this.shutDown();
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
      try {
        sock.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    /**  returns name of the peer object*/
    public String getName() {
        return name;
    }

    /** read a line from the default input */
    static public String readString() {
        //System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
