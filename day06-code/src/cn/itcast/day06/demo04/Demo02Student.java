package cn.itcast.day06.demo04;

public class Demo02Student {

    public static void main(String[] args) {
        Student stu1 = new Student();
        System.out.println("================");
        Student stu2 = new Student("Adam",25);

        System.out.println(stu2.getAge() + stu2.getName());
    }
}
