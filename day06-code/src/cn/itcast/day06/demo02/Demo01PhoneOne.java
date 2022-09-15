package cn.itcast.day06.demo02;

public class Demo01PhoneOne {

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
    }
}
