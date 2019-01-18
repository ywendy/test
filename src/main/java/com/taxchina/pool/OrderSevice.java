package com.taxchina.pool;

public class OrderSevice {


    public String  send(String name){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //
        }

        return "hello:"+name;
    }

}
