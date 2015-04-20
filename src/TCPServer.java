import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.io.*;


public class TCPServer implements Runnable{
	
	private Socket sock;
	private InputStream in;
	private OutputStream out;
	private BufferedReader buff;
	private ServerSocket ssock;
	private Thread T;
	
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
			String instring=buff.readLine();
			//String instring=inbuffer.toString();
			Thread.sleep(5000);
			System.out.println(instring);
			//System.out.println("Ricevuti tot byte:");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("FGHJK");
		}
	}
	public void run(){
		while(true){
			try {
				sock=ssock.accept();
				Date timestamp=new Date();
				Thread t=new Thread(this);
				t.start();
				//TCPServer s=new TCPServer();
				in=sock.getInputStream();
				out=sock.getOutputStream();
				buff=new BufferedReader(new InputStreamReader(in));
				this.ricevi();
				out.close();
				in.close();
				sock.close();
				this.T.stop();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
