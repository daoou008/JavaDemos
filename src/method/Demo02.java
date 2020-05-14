package method;

/*
数组的构造器引用
 */
public class Demo02 {
    public static int[] createIntArray(int len, ArrayBuilder ab) {
        return ab.buildArray(len);
    }

    public static void main(String[] args) {
        //int[] arr1 = createIntArray(10, len ->new int[10]);
        int[] arr1 = createIntArray(10, int[]::new);
        System.out.println(arr1.length);
    }
}
