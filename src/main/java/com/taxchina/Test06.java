package com.taxchina;

import com.taxchina.lock.TicketsDemo;

public class Test06 {


    public static void main(String[] args) {


        TicketsDemo ticketsDemo = new TicketsDemo();


        for(int i=1;i<=10;i++){
            new Thread(ticketsDemo, i+"号窗口").start();
        }


    }

}
