package Functional;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo3 {
    public static void main(String[] args) {
        //System.out.println(getString(() -> "Hello World!"));
/*
        //取出int数组中的最大值
        int[] arr = {5,2,31,5,632,12,3,6,8};
        int max = getMax(() -> {
            int result = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (result < arr[i]){
                    result = arr[i];
                }
            }
            return result;
        });
        System.out.println("数组的最大值是：" + max);*/

        //printName("张三丰", (s) -> System.out.println("你的名字是：" + new StringBuilder(s).reverse()));

/*        string2User("张三丰", (name) -> {
                    System.out.println(name);
                },
                (name) -> {
                    System.out.println(new StringBuilder(name).reverse());
                });*/

/*        String[] arr = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        for (String s : arr) {
            string2User(s,
                    (g) -> System.out.print("姓名 : " + s.split(",")[0] + "， "),
                    (g) -> System.out.println("性别 : " + s.split(",")[1] + "。"));
        }*/

        /*String s = "abcd";
        System.out.println(checkData(s, s1 ->  s1.length() > 5));*/

        /*String[] arr = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        ArrayList<String> checked = filter(arr,
                message -> message.split(",")[1].equals("女"),
                message -> message.split(",")[0].length() > 3);
        System.out.println(checked);*/
        String s = "asf";
        Integer i = translate(s, (message) ->  {
            try{
                return Integer.parseInt(message);
            }catch (Exception e){
                System.out.println("字符串无法成功转换成整数");
                return 0;
            }
        });
        System.out.println("字符串\"" + s + "\"转换成数值类型是：" + i);
    }

    public static Integer translate(String s, Function<String, Integer> func){
        return func.apply(s);
    }

    public static String getString(Supplier<String> sup) {
        return sup.get();
    }

    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void printName(String name, Consumer<String> con) {
        con.accept(name);
    }

    public static void string2User(String name, Consumer<String> con1, Consumer<String> con2) {
        con1.andThen(con2).accept(name);
    }

    public static boolean checkData(String s, Predicate<String> pre){
        return pre.test(s);
    }

    public static ArrayList<String> filter(String[] arr, Predicate<String> pre1, Predicate<String> pre2){
        ArrayList<String> result = new ArrayList<>();
        for (String s : arr) {
            if (pre1.and(pre2).test(s)){
                result.add(s);
            }
        }
        return  result;
    }


}
