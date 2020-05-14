package reflect;


import common.Person;

import java.lang.reflect.Method;

public class PersonReflector {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Method method = personClass.getMethod("eat", String.class);
        method.setAccessible(true);
        method.invoke(new Person("张三", 18), "饭");
    }
}
