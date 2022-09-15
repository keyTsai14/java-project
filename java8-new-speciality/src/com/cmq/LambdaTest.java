package com.cmq;

import org.junit.Test;

import java.util.Comparator;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/4/18
 **/
public class LambdaTest {

    @Test
    public void test(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("11111111111111111111111111111");

        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(21,12);
        System.out.println(compare2);

        System.out.println("11111111111111111111111111111");

        Comparator<Integer> com3 = Integer::compare;

        int compare3 = com3.compare(21,12);
        System.out.println(compare3);

    }

}
