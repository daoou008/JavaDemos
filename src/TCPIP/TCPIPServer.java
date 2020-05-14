package TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();
        InputStream clientIn = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = clientIn.read(bytes);
        System.out.println(new String(bytes, 0, len));

        OutputStream clientOut = socket.getOutputStream();
        clientOut.write("收到，谢谢！".getBytes());

        socket.close();
        ss.close();
    }
}
