package cn.itcast.day06.demo01;

import java.util.Scanner;

public class Demo03Test03 {
    public static void main(String args[]) {
        Scanner reader=new Scanner(System.in);
        System.out.println("输入成绩:");
        double a = reader.nextDouble();

        //TODO:调用showGrade方法传入a参数
        showGrade(a);

    }

    /*
	TODO:判断成绩方法
    功能描述：编写判断成绩评比的方法，成绩在0——100之间，不在之间的输出“输入的成绩不符和规则”，
    如果大于等于90输出‘A’,大于等于80输出'B'，大于等于60输出'C'，小于60输出‘D’。
	参数说明：num:成绩
    返回值说明：无
	*/
    public static void showGrade(double num){
        if (num >= 0 && num <= 100) {
            if (num >= 90) {
                System.out.println("A");
            } else if (num >= 80) {
                System.out.println("B");
            } else if (num >= 60) {
                System.out.println("C");
            } else {
                System.out.println("D");
            }
        } else {
            System.out.println("输入的成绩不符和规则");
        }


    }
}
