package cn.itcast.day06.demo02;

public class Demo03PhoneSame {

    public static void main(String[] args) {
        Phone one = new Phone();
        one.brand = "iPhone";
        one.color = "black";
        one.price = 8388;

        System.out.println(one.brand);
        System.out.println(one.color);
        System.out.println(one.price);

        one.call("fcr");
        one.sendMessage();
        System.out.println("=======================");

        Phone two = one;
        two.brand = "huawei";
        two.color = "white";
        two.price = 6000.0;

        System.out.println(two.brand);
        System.out.println(two.color);
        System.out.println(two.price);

        two.call("fcr");
        two.sendMessage();
    }
}
