package TCPIP;

import java.io.*;
import java.net.Socket;

public class ClientUpload {
    public static void main(String[] args) throws IOException {
        System.out.println("文件开始上传");
        //定义一个本地文件流，读取本地文件
        FileInputStream localFIS = new FileInputStream(new File("F:\\Develop\\Java\\TestDocs\\111.jpg"));
        //定义客户端Socket, 以及和服务器交互的Socket字节流
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream socketOut = socket.getOutputStream();
        //读取本地字节流
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = localFIS.read(bytes)) != -1){
            //把本地字节流写入Socket
            socketOut.write(bytes, 0, len);
        }

        //给服务器发送结束标志，终止套接字，使得以前写入的数据都被发送（包括文件的结束标记）
        socket.shutdownOutput();

        //定义Input Stream，用来接收服务器返回的字节流
        InputStream ack = socket.getInputStream();
        while ((len = ack.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, len));
        }

        socket.close();
        localFIS.close();
    }
}
