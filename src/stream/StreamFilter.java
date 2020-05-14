package stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();

        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("迪丽热巴");
        arr1.add("杨幂");
        arr1.add("郭芙蓉");
        arr1.add("村上春树");
        arr1.add("张翠花");
        arr1.add("吴天天");
        arr1.add("沈腾");
        arr1.add("关晓彤");
        arr1.add("小沈阳");
        arr1.add("大张伟");
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("张三丰");
        arr2.add("张无忌");
        arr2.add("郭靖");
        arr2.add("杨过");
        arr2.add("小龙女");
        arr2.add("张小敬");
        arr2.add("黄蓉");
        arr2.add("张骞");
        arr2.add("李世民");

        Stream.concat(arr1.stream().filter(name -> name.length() == 3).limit(3)
                , arr2.stream().filter(name -> name.startsWith("张")).skip(2))
                .map(name -> new Person(name))
                .forEach(p -> System.out.println(p));

/*        for (Person person : persons) {
            System.out.println(person);
        }*/
    }
}
