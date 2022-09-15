package cn.itcast.day06.demo01;

import java.util.Scanner;

public class Demo04Test{
    public static void main(String args[]) {
            Scanner reader = new Scanner(System.in);
            System.out.println("输入项数：");
            int n = reader.nextInt();
            //TODO:调用sum方法传入n参数
            resultSum(n);
        }
   /*
    TODO:求和方法
    功能描述：编写求和方法，首项为1，项数为n,sum=1 + 1/2! +......+1/n!;
    参数说明：参数n:项数
    返回值说明：无
    */
        public static void resultSum(int n) {
            double result = 0;
            double [] array = new double[n];
            double s = 1;
            for (int i = 0; i < n; i++) {
                s *= (i + 1);
                array[i] = 1 / s;
                result += array[i];
            }
            System.out.println(result);
        }
}
