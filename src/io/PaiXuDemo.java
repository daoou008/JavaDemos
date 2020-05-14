package io;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.*;
import java.util.*;

public class PaiXuDemo {
    public static void main(String[] args) throws IOException {
        //先定义一个hasp map用来存储键值对
        HashMap<String, String> map = new HashMap<>();
        //定义一个输入流缓冲区，读取原始文件
        BufferedReader br = new BufferedReader(new FileReader("F:\\Develop\\Java\\TestDocs\\in.txt"));
        //定义一个字符串变量，用来读取文件中的字符
        String pt;
        //定义一个list，存放key，方便之后排序
        //ArrayList<String> keyList = new ArrayList<>();
        //读取每一行，直到文件结束
        while ((pt = br.readLine()) != null) {
            //把读取到的每一行，按照"."分隔，分别存在map的Key和value中
            //定义一个String数组，用来存放"."前后的内容
            String[] part = pt.split("\\.");
            if (part[0].length() > 1){
                part[0] = part[0].substring(1);
            }
            map.put(part[0], part[1]);
            //keyList.add(part[0]);
            //System.out.println(part[0]);
        }

//        System.out.println(keyList);
//        Collections.sort(keyList);
//        System.out.println(keyList);
        //定义一个输出流缓冲区，用来创建新的文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Develop\\Java\\TestDocs\\out.txt"));

        //遍历map，拼接字符串，并输出到新的文件中
        for (String s : map.keySet()) {
            String value = map.get(s);
            //逐行输出
            bw.write(s + "." + value);
            //添加换行
            bw.newLine();
        }

        //释放资源
        bw.close();
        br.close();
    }
}
