package io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("testStream.txt");
        ps.println("你好，大家好！");
        ps.close();
    }
}
