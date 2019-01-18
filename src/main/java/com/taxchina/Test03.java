package com.taxchina;

import com.alibaba.fastjson.JSON;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author think
 * @date 2019-01-14 00:24
 */
public class Test03 {

    public static void main(String[] args) {
            /**
             * 是否可以序列化？
             * 反序列化是否会报错？
             *
             */

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "d:/animal.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                     "d:/animal.txt"))) {

       /*    Animal animal01 = new Animal(1, "cat");
            System.out.println("序列化之前：" + JSON.toJSONString(animal01));
            oos.writeObject(animal01);*/
            Animal animal02 = (Animal) ois.readObject();
            System.out.println("序列化之后：" + JSON.toJSONString(animal02));
        } catch (Exception e) {

            e.printStackTrace();
        }


    }


}
