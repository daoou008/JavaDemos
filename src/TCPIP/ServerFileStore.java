package TCPIP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class ServerFileStore {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动，并分配8888端口");
        //启动服务器，并分配8888端口
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true){
            //接受客户端请求
            Socket accept = serverSocket.accept();

            //定义服务器本地文件夹，保存客户端上传的文件
            File file = new File("F:\\Develop\\Java\\ServerFolder");
            //如果文件夹不存在，创建文件夹
            if (!file.exists()) {
                file.mkdir();
            }

            //String fileName = "\\" + LocalDate.now().toString() + LocalTime.now().getHour() + LocalTime.now().getMinute() + LocalTime.now().getSecond() + ".jpg";
            //String fileName = "\\" + new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime()) + ".jpg";
            String fileName = "\\" + System.currentTimeMillis() + ".jpg";

            System.out.println(fileName);

            //定义本地文件输出流，以处理文件操作
            FileOutputStream fos = new FileOutputStream(file + fileName);

            //读取客户端文件
            InputStream clientIn = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = clientIn.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            //回写信息，告诉客户端上传文件成功，并保存到具体的目录
            OutputStream clientOut = accept.getOutputStream();
            clientOut.write("文件已成功上传".getBytes());

            System.out.println("服务器已成功处理客户端上传文件请求，并返回ack信息。");

            fos.close();
            accept.close();
        }

        //serverSocket.close();
    }
}
