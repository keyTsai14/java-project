package cn.itcast.day06.demo03;


public class Demo03Person {

    public static void main(String[] args) {
        Person person = new Person();

        person.name = "fcr";
        person.setAge(20);
        person.setMale(false);

        System.out.println(person.name + person.getAge() + person.isMale());

    }
}
