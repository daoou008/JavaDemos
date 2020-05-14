package animal;

public abstract class Animal {
    public String name;
    public String colour;
    public abstract void eat();
    public abstract void sound();

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }
}
