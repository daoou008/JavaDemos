package method;

/*
子类
 */
public class Man extends Human{
    @Override
    public void sayHello() {
        System.out.println("Hello, 我是Man!");
    }

    public void method(Greetable gt){
        gt.greet();
    }

    public void show(){
        /*method(() -> {
            super.sayHello();
        });*/
        method(super::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();
    }
}
