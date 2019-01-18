package com.taxchina;

import com.taxchina.pool.OrderSevice;

import java.util.concurrent.*;

public class Test07 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        OrderSevice orderService = new OrderSevice();
        MyCallable myCallable1 = new MyCallable(orderService,"1");
        MyCallable myCallable2 = new MyCallable(orderService,"2");
        MyCallable myCallable3 = new MyCallable(orderService,"3");

        Future<String> future1 = executorService.submit(myCallable1);
        Future<String> future2 = executorService.submit(myCallable2);
        Future<String> future3 = executorService.submit(myCallable3);

        try {
            long start = System.currentTimeMillis();
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());

//            System.out.println( orderService.send("1"));
//            System.out.println( orderService.send("2"));
//            System.out.println( orderService.send("3"));
            System.out.println("耗时："+(System.currentTimeMillis()-start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }


    }





}

class  MyCallable implements Callable<String>{
    private OrderSevice orderSevice;
    private String name;

    public MyCallable(OrderSevice orderSevice,String name) {
       this.orderSevice = orderSevice;
       this.name = name;
    }

    @Override
    public String call()  {
        return orderSevice.send(name);
    }
}
