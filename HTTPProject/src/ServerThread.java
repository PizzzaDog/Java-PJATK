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

//    public String getHost() {
//
//        String secondLine;
//        String[] arr;
//
//        String host="";
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("request.txt"));
//            reader.readLine();
//
//            secondLine = reader.readLine();
//            arr = secondLine.split(" ");
//            host = arr[1];
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//
//        return host;
//    }

        public String getHost(byte[] req) {
        String requestString = new String(req);
        String[] arrRequestByLine = requestString.split("\n");
        String [] arrByWord = arrRequestByLine[1].split(" ");
        return arrByWord[1];
        }

    public void run() {

        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter writeRequest = new PrintWriter(new FileWriter("request.txt"));
//
//            String request;
//
//            while(( request= in.readLine()) != null && !request.isEmpty())
//            {
//                writeRequest.println(request);
//
//            }
//            writeRequest.close();
//
//
//            String host = getHost();
//
//            System.out.println(host);
//
//            browser = new Socket(host, 80);
//
//            //PrintWriter requestToHost = new PrintWriter(browser.getOutputStream());
//
//            BufferedWriter requestToHost = new BufferedWriter(new OutputStreamWriter(browser.getOutputStream()));
//
//
//
//            BufferedReader readerFromFile = new BufferedReader(new FileReader("request.txt"));
//
//            String sendRequest;
//
//            while((sendRequest = readerFromFile.readLine()) != null && !sendRequest.isEmpty()) {
//                requestToHost.write(sendRequest);
//                requestToHost.newLine();
//                requestToHost.flush();
//            }
//                //requestToHost.close();
//
//
////            while((sendRequest = readerFromFile.readLine()) != null && !sendRequest.isEmpty()) {
////                //System.out.println(sendRequest);
////                requestToHost.print(sendRequest);
////            }
////            requestToHost.close();
//
//            readerFromFile.close();
//
//
//            PrintWriter client = new PrintWriter(socket.getOutputStream(),true);
//
//            BufferedReader browserStream = new BufferedReader(new InputStreamReader(browser.getInputStream()));
//
//            String respond;
//
//            while(( respond = browserStream.readLine()) != null && !respond.isEmpty()) {
//                client.println(respond);
//                System.out.println(respond);
//            }


            byte[] request = new byte[1024];
            byte[] response = new byte[1024];

            InputStream in = new BufferedInputStream(socket.getInputStream());

            in.read(request);

            String host = getHost(request);
            System.out.println(host);

            hostSocket = new Socket(host, 80);
            OutputStream requestToServer = null;
            try{
                requestToServer = new BufferedOutputStream(hostSocket.getOutputStream());
                requestToServer.write(request);
                requestToServer.flush();
            }catch(IOException e){
                System.out.println();
            }



            InputStream responseFromServer = new BufferedInputStream(hostSocket.getInputStream());
            OutputStream responseToClient = new BufferedOutputStream(socket.getOutputStream());

            //responseFromServer.read(response);

            //String resp = new String(response);
            //System.out.println(resp);

            int tmp;
            while ((tmp = responseFromServer.read(response)) != -1) {
                responseToClient.write(response, 0, tmp);
                responseToClient.flush();
            }

            //responseToClient.write(response);


            in.close();
            responseFromServer.close();
            if(requestToServer!=null){
                requestToServer.close();
            }

            responseToClient.close();



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