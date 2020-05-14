import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
//        System.out.println("开始执行主方法");
//
//        Person person = new Person("沈坚", 38, "男");
//        System.out.println(person.name + "的年龄是" + person.age + ",性别是" + person.sex);
//        SimpleCalculator sc = new SimpleCalculator();
//        sc.calculate();

        Collection<String> str = new ArrayList<>();
        str.add("张三");
        str.add("李四");
        str.add("王五");
        System.out.println(str);

        Iterator<String> iterator = str.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
