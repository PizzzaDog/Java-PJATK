import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
    private Socket socket;
    private Proxy server;
    private Socket hostSocket;


    public ServerThread(Socket socket, Proxy server) {
        super();
        this.socket = socket;
        this.server = server;
    }

    public String getHost(byte[] req) {
        String requestString = new String(req);
        String[] arrRequestByLine = requestString.split("\r?\n");
        String[] arrByWord = arrRequestByLine[1].split(" ");
        return arrByWord[1];

    }

    public void run() {

        try {
            byte[] request = new byte[1024];
            byte[] response = new byte[102400];

            InputStream in = new BufferedInputStream(socket.getInputStream());

            in.read(request);
            //System.out.print(new String(request));

            String host = getHost(request);

            System.out.println("HOST " + host);

            hostSocket = new Socket(host, 80);
            OutputStream requestToServer = new BufferedOutputStream(hostSocket.getOutputStream());
            InputStream responseFromServer = new BufferedInputStream(hostSocket.getInputStream());

            try {
                requestToServer.write(request);
                requestToServer.flush();
            } catch(IOException e) {
                System.out.println(e);
            }

            OutputStream responseToClient = new BufferedOutputStream(socket.getOutputStream());

            int bytesRead;
            while ((bytesRead = responseFromServer.read(response)) != -1) {
                responseToClient.write(response, 0, bytesRead);
                responseToClient.flush();
                System.out.println(new String(response));
            }

            in.close();
            responseFromServer.close();
            responseToClient.close();
            requestToServer.close();



        } catch (IOException e1) {
            // do nothing
        }

        try {
            socket.close();
            if(hostSocket != null) {
                hostSocket.close();
            }
        } catch (IOException e) {
            // do nothing
        }
    }
}