package io;


import java.io.*;
import java.util.ArrayList;

public class ObjOutputDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\Develop\\Java\\TestDocs\\testPerson.txt"));
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("杨过", 18));
        persons.add(new Person("小龙女", 21));
        oos.writeObject(persons);
        oos.close();*/
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\Develop\\Java\\TestDocs\\testPerson.txt"));
        //Object obj = ois.readObject();
        try{
            ArrayList<Person> persons = (ArrayList<Person>)ois.readObject();
            for (Person person : persons) {
                System.out.println(person.name + "---->" + person.age);
            }
        }catch (Exception e){
            System.out.println("反序列化异常");
        }finally {
            ois.close();
        }
        //System.out.println(obj);
    }

    public static class Person implements Serializable {
        //自定义序列号
        private static final long serialVersionUID = 100L;
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
