import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
	private Socket socket;

	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
			String line;
			if((line = in.readLine()) != null && !line.isEmpty())
			{
				System.out.println(line);	
			}
			String[] words = line.split(" ", 4);
			String name = words[1];
			String ip = words[2];
			String port = words[3];
			
			switch(words[0]) {
  				case "REGISTER":
					n.put(name, ip + " " + port);
    				break;
  				case "GET":
					out.println(n.get(name));
					break;
				case "CALL":
					String s[] = n.get(name).split(" ");
					Strign ip_pr = s[1];
					Strign prot_pr = s[2];
					String messg = words[4];
					out.println(new TCPClient(ip_pr,port_pr,messg));
					break;
			}
		} catch (IOException e1) {
			// do nothing
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			// do nothing
		}
	}
}