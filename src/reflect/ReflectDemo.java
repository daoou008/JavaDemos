package reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings("all")
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties pro = new Properties();
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //2.获取配置文件中定义的参数
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class aClass = Class.forName(className);
        //4.创建对象
        Object o = aClass.newInstance();
        //5.获取方法对象
        Method method = aClass.getMethod(methodName);
        method.setAccessible(true);
        method.invoke(o);
    }
}
