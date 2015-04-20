import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;


public class TCPClient {
	
	private Socket sock;
	private OutputStream out;
	
	public TCPClient(){
		try {
			sock=new Socket(InetAddress.getByName("localhost"),12345);
			String outString =new String("Provaa");
			byte buff[]=outString.getBytes();
			out=sock.getOutputStream();
			out.write(buff);
			out.close();
			sock.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
