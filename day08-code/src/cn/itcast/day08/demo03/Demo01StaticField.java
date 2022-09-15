package cn.itcast.day08.demo03;

public class Demo01StaticField {

    public static void main(String[] args) {
        Student one = new Student("Adam",19);
        one.room = "101教室";
        System.out.println("name:" + one.getName()
                + ",age:" + one.getAge() + ",classroom:" + one.room
                + ",id:" + one.getId());
        Student two = new Student("Abby", 20);
        System.out.println("name:" + two.getName()
                + ",age:" + two.getAge() + ",classroom:" + two.room
                + ",id:" + two.getId());
    }
}
