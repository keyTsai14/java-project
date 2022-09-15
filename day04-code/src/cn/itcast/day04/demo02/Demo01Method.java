package cn.itcast.day04.demo02;
/*
定义格式：
public static void 方法名称() {
    方法体
}

调用格式：
方法名称();

注意：
1，方法定义不分先后顺序
2，方法定义必须是挨着的，不能在一个方法的内部定义另一个方法
3，方法定义之后，自己不会执行，如希望执行，一定要进行方法的调用。

 */
public class Demo01Method {
    public static void main(String[] args) {
        printMethod();
    }

    public static void printMethod() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
