import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
    private Socket socket;
    private Socket hostSocket;

    public ServerThread(Socket socket) {
        super();
        this.socket = socket;
    }

    public String getHost(byte[] req) {
        String requestString = new String(req);
        String[] arrRequestByLine = requestString.split("\r\n");
        String[] arrByWord = arrRequestByLine[1].split(" ");
        return arrByWord[1];
    }

    public void run() {
        InputStream in;
        OutputStream requestToServer;
        InputStream responseFromServer;
        OutputStream responseToClient;


        try {
            byte[] request = new byte[1024];
            byte[] response = new byte[1024];

            in = new BufferedInputStream(socket.getInputStream());
            in.read(request);
            String req = new String(request);
            boolean IsGetRequest = req.contains("GET");

            if(IsGetRequest) {


                String host = getHost(request);
                hostSocket = new Socket(host, 80);

                requestToServer = new BufferedOutputStream(hostSocket.getOutputStream());
                responseFromServer = new BufferedInputStream(hostSocket.getInputStream());
                responseToClient = new BufferedOutputStream(socket.getOutputStream());

                requestToServer.write(request);
                requestToServer.flush();

                int bytesRead;

                while ((bytesRead = responseFromServer.read(response)) != -1) {
                    responseToClient.write(response, 0, bytesRead);
                    responseToClient.flush();
                }

                in.close();
                responseFromServer.close();
                responseToClient.close();
                requestToServer.close();
            }

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