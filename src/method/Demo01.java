package method;

public class Demo01 {
    public static void printString(Printable pa) {
        pa.print("Hello World!");
    }

    public static void main(String[] args) {
        /*printString((str) -> {
            MethodRefObject mro = new MethodRefObject();
            mro.toUpper(str);
        });*/
        printString(MethodRefObject::toUpper);
    }
}
