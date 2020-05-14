package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectEveryClass {
    public Object obj;
    public static void runMethod(String className, String methodName, String... args){
        try {
            Class aClass = Class.forName(className);
            Method method = aClass.getMethod(methodName, String.class);
            method.setAccessible(true);
            method.invoke(aClass.newInstance(), args);
        } catch (ClassNotFoundException e) {
            System.out.println("无法找到对应的类!");
        } catch (NoSuchMethodException e) {
            System.out.println("无法找到对应的方法!");
        } catch (IllegalAccessException e) {
            System.out.println("您没有权限访问该方法!");
        } catch (InvocationTargetException e) {
            System.out.println("目标方法调用失败!");
        } catch (InstantiationException e) {
            System.out.println("对象实例化失败!");
        } catch (IllegalArgumentException e) {
            System.out.println("参数使用异常!");
        }
    }
}
