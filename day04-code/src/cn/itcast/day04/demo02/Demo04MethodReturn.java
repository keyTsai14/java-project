package cn.itcast.day04.demo02;

/*
题目要求：定义一个方法，用来【求出】两数之和。（你帮我算，算完之后把结果告诉我）
题目变形：定义一个方法，用来【打印】两数之和。（你来计算，算完之后你自己负责显示结果，不用告诉我。）
 */
public class Demo04MethodReturn {

    public static void main(String[] args) {
        //我是main方法，我来调用你。
        //我调用你，你来帮我计算一下，算完把结果告诉我的num变量
        int num = getSum(10,20);
        System.out.println("返回值是：" + num);
        System.out.println("=======================");

        printSum(100,200);
    }

    //我是一个方法，负责两数相加
    //我有一个返回值int，谁调用我，我就把计算结果告诉谁
    public static int getSum(int a, int b) {
        int result = a + b;
        return result;
    }

    //我是一个方法，我负责两数相加
    //我没有返回值，不会把结果告诉任何人，而是我自己进行打印输出
    public static void printSum(int a, int b) {
        int result = a + b;
        System.out.println("结果是：" + result);
    }
}
