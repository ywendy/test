package com.taxchina;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Constructor;

/**
 * @author think
 * @date 2019-01-14 00:33
 */
public class Test04 {

    public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getInstance();
        System.out.println("s1:" + UnsafeUtil.getAddress(s1));
        Singleton s2 = Singleton.getInstance();
        System.out.println("s2:" + UnsafeUtil.getAddress(s2));

        Class<Singleton> cls = Singleton.class;
        Constructor<Singleton> c = cls.getDeclaredConstructor();
        c.setAccessible(true);
        Singleton s3 = c.newInstance();
        System.out.println("s3:" + UnsafeUtil.getAddress(s3));

        String s = JSON.toJSONString(s1);
        Singleton s4 = JSON.parseObject(s, Singleton.class);
        System.out.println("s4:" + UnsafeUtil.getAddress(s4));


        SingletonEnum ss01 = SingletonEnum.INSTANCE;
        System.out.println("ss01:" + UnsafeUtil.getAddress(ss01));
        String ss = JSON.toJSONString(ss01);
        SingletonEnum ss02 = JSON.parseObject(ss, SingletonEnum.class);
        System.out.println("ss02:" + UnsafeUtil.getAddress(ss02));
/*
        Constructor<SingletonEnum> cc = SingletonEnum.class.getDeclaredConstructor();


        cc.setAccessible(true);
        SingletonEnum ss03 = cc.newInstance();
        System.out.println("ss03:" + UnsafeUtil.getAddress(ss03));*/


    }


}
