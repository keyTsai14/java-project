package cn.itcast.day07.demo03;

import java.util.Random;

public class Demo03Random {

    public static void main(String[] args) {
        Random r = new Random();
        int n = 5;
        int num = r.nextInt(n) + 1;
        System.out.println(num);
    }
}
