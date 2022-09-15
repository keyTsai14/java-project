package cn.itcast.day07.demo03;

import java.util.Random;

/*
Random类 生成随机数

创建格式：
Random r = new Random（）；

使用
获取一个随机的int数字（范围是int所有范围，有正负两种），int num = r.nextInt（）
获取一个随机的int数字（参数代表了范围，左闭右开区间），int num = r.nextInt（3）
实际上代表的含义就是：[0,3)
 */
public class Demo01Random {

    public static void main(String[] args) {
        Random r = new Random();

        int num = r.nextInt();
        System.out.println(num);
    }
}
