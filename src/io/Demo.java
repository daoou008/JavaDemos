package io;

import java.io.*;

public class Demo {
    //建议： 复制带中文的文件，用字符流
    //      复制其他文件，用字节流
    public static void main(String[] args) throws IOException {
        //获取当前时间
        long t1 = System.currentTimeMillis();

        //读取文件
        //BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\Develop\\Java\\TestDocs\\111.jpg"));
        BufferedReader br = new BufferedReader(new FileReader("F:\\Develop\\Java\\TestDocs\\123.txt"));

        //定义读取的字符串数组，以及读取文件字节当前位置的值
        char[] chars = new char[1024];
        int len = 0;

        //定义文件输出信息
        //BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\Develop\\Java\\TestDocs\\111_copy.jpg"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Develop\\Java\\TestDocs\\123_copy.txt"));

        while (-1 != (len = br.read(chars))) {
             bw.write(String.valueOf(chars), 0, len);
        }

        //再次获取当前时间，并输出时间差（文件拷贝所用的时间）
        long t2 = System.currentTimeMillis();
        System.out.println("文件拷贝时间：" + (t2 - t1) + "毫秒");

        //关闭缓冲区，释放资源
        bw.close();
        br.close();
    }
}
