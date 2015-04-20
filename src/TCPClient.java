
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;


public class TCPClient {
	
	private Socket sock;
	private OutputStream out;
	private InputStream in;
	private BufferedReader bufferedIn;
	public TCPClient(){
		try {
			sock=new Socket("localhost",12345);
			String outString =new String("Provaa\n");
			byte[] buff=outString.getBytes();
			out=sock.getOutputStream();
			in=sock.getInputStream();
			bufferedIn=new BufferedReader(new InputStreamReader(in));
			out.write(buff);
			System.out.println("Inviati");
			while(!bufferedIn.ready()){}
			System.out.println("Buffer pronto");
			String inString=bufferedIn.readLine();
			System.out.println(inString);
			bufferedIn.close();
			in.close();
			out.close();
			sock.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
