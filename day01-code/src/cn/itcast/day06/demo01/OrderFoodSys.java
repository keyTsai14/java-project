package cn.itcast.day06.demo01;
import java.util.Scanner;

//在线订餐系统
public class OrderFoodSys {
    public static void main(String[] args) {
        //定义数据主体：菜品
        String[] dishNames = {"糖醋排骨","鱼香肉丝","水煮菜心"};  //菜品名称
        double[] prices = {38.0,20.0,30.0};//单价
        int[] praiseNums = new int[3];//点赞数
        //定义数据主体：订单-订餐人	餐品信息		送餐时间	送餐地址		总金额	订单状态
        String[] names = new String[4];
        String[] dishMsg = new String[4] ; //菜品名称+订份数
        int[] times = new int[4];
        String[] adresses = new String[4];
        double[] sumPrices = new double[4];
        int[] states = new int[4]; //0：已预订   1：已完成

        //初始化2个订单信息
        names[0] = "晓静";
        dishMsg[0] = "糖醋排骨 2份";
        times[0] = 10;
        adresses[0] = "长春路13号";
        sumPrices[0] = 76; //餐费>50 免配送费，不然，配送费6元
        states[0] = 0;

        names[1] = "王红";
        dishMsg[1] = "鱼香肉丝 1份";
        times[1] = 13;
        adresses[1] = "珠江路27号";
        sumPrices[1] = 26; //餐费>50 免配送费，不然，配送费6元
        states[1] = 1;

        //搭建项目整体流程框架
        Scanner input = new Scanner(System.in);
        int num = -1; //用户输入0返回时的输入数字，num=0时重复显示主菜单;num在用户每次订餐操作后进行提示重新赋值
        //TODO1:修改以下打印语句，使其能打印出 欢迎使用"在线订餐系统" 的字样来。注意需要将引号打印出来。
        System.out.println("欢迎使用\"在线订餐系统\"");
        //记录用户是否退出系统的状态：退出true   不退出false
        boolean flag = false;

        do{
            System.out.println("*************************");
            System.out.println("1、我要订餐");
            System.out.println("2、查看餐袋");
            System.out.println("3、签收订单");
            System.out.println("4、删除订单");
            System.out.println("5、我要点赞");
            System.out.println("6、退出系统");
            System.out.println("*************************");
            System.out.println("请选择：");
            int choose = input.nextInt();
            switch(choose){
                case 1:
                    System.out.println("*********我要订餐**************");
                    //订餐。。。。。

                    break;
                case 2:
                    System.out.println("*********查看餐袋**************");
                    break;
                case 3:
                    System.out.println("*********签收订单**************");
                    break;
                case 4:
                    System.out.println("*********删除订单**************");
                    break;
                case 5:
                    System.out.println("*********我要点赞**************");
                    break;
                case 6:
                    //TODO2:完成退出标志的设置，以便退出系统
                    System.out.println("*********退出系统**************");
                    flag = true;
                    break;
                default:
                    //TODO3:完成退出标志的设置，以便退出系统
                    System.out.println("*********退出系统**************");
                    flag = true;
                    break;
            }
            //TODO4:检查退出标志
            if(flag != true){
                System.out.println("请输入0返回：");
                num = input.nextInt();
            }else{
                //TODO5:退出循环体语句
                break;
            }
        }while(num==0);
        System.out.println("谢谢使用，欢迎下次光临！");
    }
}