package cn.itcast.day08.demo03;

public class Demo02StaticMethod {

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.method();

        obj.methodStatic();// 不推荐，这种写法在编译之后也会被javac翻译成为“类名称.静态方法名”
        MyClass.methodStatic();

        // 对于本类当中的静态方法，可以省略类名称
        myMethod();
        Demo02StaticMethod.myMethod();// 完全等效
    }

    public static void myMethod() {
        System.out.println("自己的方法！！！！");
    }
}
