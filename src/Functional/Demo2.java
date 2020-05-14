package Functional;

import java.util.Arrays;
import java.util.Comparator;

public class Demo2 {
    public static Comparator<String> getComparator() {
        return (o1, o2) -> o2.length() - o1.length();
    }

    public static void main(String[] args) {
        String[] strings = {"aa", "b", "ccccc", "ddd"};
        System.out.println(Arrays.toString(strings));

        System.out.println("排序后============================");
        Arrays.sort(strings, getComparator());
        System.out.println(Arrays.toString(strings));
    }
}
