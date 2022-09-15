package cn.itcast.day04.demo04;

/*
题目要求：
比较两个数据是否相等。
参数类型分别为两个byte类型，两个short类型，两个int类型，两个long类型，
并在main方法中进行测试
 */
public class Demo02MethodOverloadSame {

    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        System.out.println(isSame(a, b));
        System.out.println("=============");

        System.out.println(isSame((short) 10, (short) 10));
        System.out.println("=============");


    }

    public static boolean isSame(byte a, byte b){
        System.out.println("byte方法执行成功");
        return a == b;
    }

    public static boolean isSame(short a, short b){
        System.out.println("short方法执行成功");
        return a == b;
    }

    public static boolean isSame(int a, int b){
        System.out.println("int方法执行成功");
        return a == b;
    }

    public static boolean isSame(long a, long b){
        System.out.println("long方法执行成功");
        return a == b;
    }

}
