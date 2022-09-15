package cn.itcast.day06.demo04;

public class Demo01Person {

    public static void main(String[] args) {

        Person person = new Person();
        person.name = "Father";

        person.sayHello("son");
        System.out.println(person);
    }
}
