package cn.itcast.day05.demo04;

/*
一个方法可以有0，1，多个参数；但是只能有0或者1个返回值，不能有多个返回值。
如果希望一个方法当中产生了多个结果数据进行返回，怎么办？
解决方案：使用一个数组作为返回值类型即可
 */
public class Demo02ArrayReturn {

    public static void main(String[] args) {
        int[] result = calculate(10, 20 ,30);

        System.out.println("main方法接收到返回值数组是：");
        System.out.println(result);

        System.out.println("Sum = " + result[0]);
        System.out.println("Avg = " + result[1]);

    }

    public static int[] calculate(int a, int b, int c) {
        int sum = a + b + c;
        int avg = sum / 3;

        int[] array = {sum, avg};
        System.out.println("calculate方法内部数组是：");
        System.out.println(array);
        return array;
    }


}
