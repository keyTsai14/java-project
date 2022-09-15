package cn.itcast.day07.demo04;

/*
数组有一个缺点：
一旦创建，程序运行过程中长度不可以发生改变

 */
public class Demo01Array {

    public static void main(String[] args) {
        Person[] array = new Person[3];
        Person one = new Person("Adam",15);
        Person two = new Person("Bob",25);
        Person three = new Person("Cindy",35);

        array[0] = one;
        array[1] = two;
        array[2] = three;

    }
}
