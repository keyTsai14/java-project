package cn.itcast.day07.demo03;

import java.util.Random;
import java.util.Scanner;

public class Demo04RandomGame {

    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);

        while (true) {// 循环次数不确定，用此无限循环
            System.out.println("请输入的你猜的数字：");
            int guessNum = sc.nextInt();

            if (guessNum > randomNum) {
                System.out.println("too big");
            } else if (guessNum < randomNum) {
                System.out.println("too small");
            } else {
                System.out.println("congratulate");
                break;
            }
        }

    }
}
