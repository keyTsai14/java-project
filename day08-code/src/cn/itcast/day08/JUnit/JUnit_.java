package cn.itcast.day08.JUnit;/**
 * @author key
 */

import org.junit.jupiter.api.Test;

/**
 * @Description 单元测试
 * @Author admin
 * @Date 2022/1/27
 **/
public class JUnit_ {
    public static void main(String[] args) {
        String a = "1001";
        String b = "111";
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for (int i = a.length()-1,j = b.length()-1;i>=0||j>=0;i--,j--) {
            sum += i>=0? a.charAt(i) -'0':0;
            sum += j>=0? b.charAt(j) -'0':0;
            sb.append(sum%2);
            sum /=2;
        }
        sb.append(sum==1?sum:"");
        System.out.println(sb.reverse().toString());
    }

    @Test
    public void test01() {
        System.out.println("test01方法被调用");
    }

    @Test
    public void test02() {
        System.out.println("test02方法被调用");
    }
}
