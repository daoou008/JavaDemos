package common;

import animal.Animal;

public class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("狗狗吃骨头");
    }

    @Override
    public void sound() {
        System.out.println("狗狗汪汪叫");
    }

    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, String colour) {
        super(name, colour);
    }
}
