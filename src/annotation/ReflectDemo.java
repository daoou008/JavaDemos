package annotation;

import java.lang.reflect.Method;

@Pro(className = "common.Person", methodName = "eat")
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //1.获取注解
        Class<ReflectDemo> ref = ReflectDemo.class;
        //2.获取上边的注解
        Pro an = ref.getAnnotation(Pro.class);
        //3.调用注解对象定义抽象的方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        //4.使用类加载器
        Class aClass = Class.forName(className);
        //5.创建对象
        Object o = aClass.newInstance();
        //6.获取对象方法，并获得权限
        Method method = aClass.getMethod(methodName);
        method.setAccessible(true);
        //7.执行方法
        method.invoke(o);
    }
}
