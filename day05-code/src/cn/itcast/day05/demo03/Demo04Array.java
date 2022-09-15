package cn.itcast.day05.demo03;

/*
遍历数组，说的就是对数组当中的每一个元素进行逐一、挨个儿进行处理。
默认的处理方式就是打印输入
 */
public class Demo04Array {

    public static void main(String[] args) {
        int[] array = { 15, 25, 45, 53, 32, 54};

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("===================");

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
