package annotation;

import calculator.SimpleCalculator;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws IOException {
        System.out.println("测试开始!");
        //0.定义测试方法需要的参数
        int x = 14;
        int y = 0;
        //记录异常次数
        double num = 0;
        double methodCount = 0;
        //定义文件，保存异常记录
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Develop\\Java\\TestDocs\\testResult.txt"));
        //1.创建对象
        SimpleCalculator cal = new SimpleCalculator();
        //2.获取字节码文件对象
        Class aClass = cal.getClass();
        //3.获取所有方法，判断是否有@Check注解，如果有，执行方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                method.setAccessible(true);
                try {
                    method.invoke(cal, x, y);
                    //4.捕获异常，记录到文件中
                } catch (Exception e) {
                    num++;
                    bw.write(method.getName() + "方法出异常了!");
                    bw.newLine();
                    bw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常信息：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("========================================");
                    bw.newLine();
                }

                methodCount++;
            }
        }

        double passRate = (methodCount == 0 ? 0 : (methodCount - num) / methodCount);
        bw.write("本次测试共测试" + (int)methodCount + "个方法，其中有异常的方法个数为：" + (int)num + "，测试通过率" + (passRate * 100) + "%");

        bw.flush();
        bw.close();

        System.out.println("测试结束!");
    }
}
