package cn.itcast.day05.demo02;

/*
直接打印数组，得到的是数组对应的：内存地址哈希值。

访问数组元素的格式：数组名称[索引值]
索引值：就是一个int数字，代表数字当中元素的编号。
【注意】索引值从0开始，一直到“数组的长度-1”为止。
 */
public class Demo04ArrayUse {

    public static void main(String[] args) {
        //静态初始化的省略格式
        int[] arrayA = {10, 20 ,30};

        System.out.println(arrayA);//[I@1b6d3586

        System.out.println(arrayA[0]);// 10
        System.out.println(arrayA[1]);// 20
        System.out.println(arrayA[2]);// 30
        System.out.println("==================");

        //也可将数组当中的某一个单个元素，赋值交给变量
        int num = arrayA[1];
        System.out.println(num);// 20


    }
}
