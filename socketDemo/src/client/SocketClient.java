package client;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient();
        socketClient.start();
    }
    public void start(){
        BufferedReader inputReader = null;
        BufferedWriter writer = null;
        BufferedReader reader = null;
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",9898);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            inputReader = new BufferedReader(new InputStreamReader(System.in));
            String inputContent;
            while (!(inputContent = inputReader.readLine()).equals("bye")){
//                System.out.println(inputContent);
                writer.write(inputContent+"\n");
                writer.flush();
                String response = reader.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                inputReader.close();
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
