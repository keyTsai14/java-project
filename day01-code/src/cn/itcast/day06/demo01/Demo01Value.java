package cn.itcast.day06.demo01;


import java.util.Scanner;

public class Demo01Value {

    public static void main(String[] args) {
        boolean isLuck;

        Scanner input = new Scanner(System.in);
        System.out.println("请输入4位会员卡号：");
        int id = input.nextInt();

        if(id > 999|| id < 10000) {


        } else {
            System.out.println("无效id");
        }
    }
}
