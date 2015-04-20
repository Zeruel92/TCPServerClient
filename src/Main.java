
public class Main {

	public static void main(String[] args) {
		if(args[0].equals("server")){
			TCPServer ss=new TCPServer();
		}
		else{
		TCPClient cc=new TCPClient();
		}
	}

}
