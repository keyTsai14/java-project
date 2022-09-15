package cn.itcast.day04.demo03;

/*
题目要求：
定义一个方法，用来打印指定次数的HelloWorld。
 */
public class Demo03MethodPrint {

    public static void main(String[] args) {
        countPrint(5);

    }

    public static void countPrint(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello, World!!" + (i + 1));
        }
    }
}
