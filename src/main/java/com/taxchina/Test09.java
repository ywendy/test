package com.taxchina;

/**
 * -XX:AutoBoxCacheMax=
 *
 * @author think
 * @date 2019-01-18 15:56
 */
public class Test09 {

    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 1;
        Integer c = 1000;
        Integer d = 1000;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
    }


}
