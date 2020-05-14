package Functional;

public class Demo {
    public static void startThread(Runnable run) {
        //开启多线程
        new Thread(run).start();
    }

    public static void main(String[] args) {
        //主方法线程
        System.out.println("主方法线程：" + Thread.currentThread().getName());
        //调用多线程
        startThread(() -> System.out.println("开启新的线程" + Thread.currentThread().getName()));
    }
}
