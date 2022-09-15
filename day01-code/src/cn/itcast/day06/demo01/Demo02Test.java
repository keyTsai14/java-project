package cn.itcast.day06.demo01;

import java.util.Scanner;

public class Demo02Test {

    public static void main (String[] args) {

        System.out.println("请输入一个汉字或日文：");
        Scanner scanner = new Scanner(System.in);

        //TODO:输入一个字符，然后使用charAt函数转化为char类型的变量c
        String s = scanner.nextLine();
        char c = s.charAt(0);

        System.out.println("汉字或日文:"+c+"的位置:"+(int)c);
        System.out.println("请输入Unicode表的位置（数字）");

        //TODO:使用Scanner输入一个整数，并赋值给变量n
        int n = scanner.nextInt();

        System.out.println(n+"位置上的字符是:"+(char)n);

    }
}
