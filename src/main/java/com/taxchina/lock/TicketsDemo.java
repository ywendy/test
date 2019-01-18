package com.taxchina.lock;

public class TicketsDemo implements Runnable {
    private static int totalCount = 100;


    @Override
    public void run() {
        while (true){
            if (totalCount>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    //skip
                }
                sale();
            }
        }
    }

    private   synchronized   void sale(){
        if (totalCount > 0) {
            --totalCount;//已经卖出，票的总数减去1
            System.out.println(Thread.currentThread().getName() + " 卖出 " + (100-totalCount) + " 号票，剩余："+totalCount);

        }
    }

    public void abc(){

    }

}
