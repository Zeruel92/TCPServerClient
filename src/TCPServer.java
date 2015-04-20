import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class TCPServer implements Runnable{
	
	private Socket sock;
	private InputStream in;
	private OutputStream out;
	private BufferedReader buff;
	private ServerSocket ssock;
	private Thread T;
	private String inString;
	private String outString;
	
	public TCPServer(){
		try {
			ssock=new ServerSocket(12345);
			T=new Thread(this);
			T.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ricevi(){
		try {
			inString="";
			System.out.println("Receiving");
			inString=buff.readLine();
			System.out.println(inString);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("FGHJK");
		}
	}
	
	public void process(){
		System.out.println("Processing");
		outString=inString.toUpperCase();
	}
	
	public void sendResponse(){
		System.out.println("Sending Response");
		byte[] outBuffer=outString.getBytes();
		try {
			out.write(outBuffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
			try {
				sock=ssock.accept();
				Thread t=new Thread(this);
				t.start();
				out=sock.getOutputStream();
				in=sock.getInputStream();
				buff=new BufferedReader(new InputStreamReader(in));
				this.ricevi();
				this.process();
				this.sendResponse();
				buff.close();
				out.close();
				in.close();
				sock.close();
				this.T.stop();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
