package cn.itcast.day07.demo04;

import java.util.ArrayList;

/*
数组的长度不可以发生改变
但是ArrayList集合的长度可以随意变化的

对于ArrayList来说，有一个尖括号<E>代表泛型。
泛型：也就是装在集合当中的所有元素，全部都是统一的什么类型
注意：泛型只能是引用类型，不能是基本类型

注意事项：
对于ArrayList集合来说，直接打印得到的不是地址值，而是内容。
如果内容是空，得到的是空的中括号：[]

ArrayList当中的常用方法有：

public boolean add(E e):向集合当中添加元素，参数的类型和泛型一致
备注：对于ArrayList集合来说，add添加动作一定会成功的，所以返回值可用可不用
但是对于其他集合，add添加动作不一定成功

public E get(int index):从集合当中获取元素，参数是索引编号，返回值就是对应位置的元素

public E remove(int index):从集合当中删除元素，参数是索引编号，返回值就是被删除的元素

public int size():获取集合的尺寸长度，返回值时集合中包含的元素个数
 */
public class Demo02ArrayList {

    public static void main(String[] args) {
        // 创建了一个ArrayList集合，集合的名称是list，里面装的全都是String字符串类型的数据
        // 备注：从jdk1.7+开始，右侧的尖括号内部可以不写内容，但是<>本身还是要写的。
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);// []

        // 向集合当中添加一些数据，需要用到add方法
        list.add("Adam");
        System.out.println(list);
        list.add("Bob");
        list.add("Cindy");
        list.add("Doggy");
        System.out.println(list);// [Adam, Bob, Cindy, Doggy]

        // 从集合中获取元素：get。索引值从0开始
        String name = list.get(2);
        System.out.println(name);




    }
}
