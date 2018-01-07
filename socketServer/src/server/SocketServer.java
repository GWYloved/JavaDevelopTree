package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        socketServer.startServer();
    }
    public void startServer(){
        ServerSocket serverSocket = null;
        BufferedReader bufferedReader = null;
        BufferedWriter writer = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(9898);
            System.out.println("server started ...");
            socket = serverSocket.accept();
            System.out.println("client "+socket.hashCode()+" connected");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String recvMsg;
            while ((recvMsg = bufferedReader.readLine())!=null){
                System.out.println(recvMsg);
                writer.write(recvMsg+" received"+"\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
                writer.close();
                bufferedReader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
