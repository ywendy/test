package com.taxchina;

import com.alibaba.fastjson.JSON;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author think
 * @date 2019-01-14 01:14
 */
public class Test05 {
    public static void main(String[] args) throws InstantiationException {
        Unsafe unsafe = UnsafeUtil.getUnsafe();
        Animal animal = (Animal) unsafe.allocateInstance(Animal.class);
        animal.setId(1);
        animal.setName("animal");
        System.out.println("animal:" + UnsafeUtil.getAddress(animal)+","+ JSON.toJSONString(animal));




    }
}
