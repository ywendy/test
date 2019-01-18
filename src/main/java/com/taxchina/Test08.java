package com.taxchina;

import com.alibaba.fastjson.JSON;
import com.taxchina.pool.OrderSevice;
import com.taxchina.pool.ThreadFactoryImpl;

import java.util.concurrent.*;

public class Test08 {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAXIMUM_POOL_SIZE = 10;
    private static final int KEEP_ALIVE_TIME = 100;

    private static final BlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<>(10);
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME,
            TimeUnit.SECONDS, WORK_QUEUE, new ThreadFactoryImpl("myThread"), (r, executor) -> System.out.println(JSON.toJSONString(executor)));


    public static void main(String[] args) {

        OrderSevice orderSevice = new OrderSevice();
        for (int i = 0; i < 100; i++) {
            final int index = i;
            threadPoolExecutor.execute(() -> System.out.println(orderSevice.send(String.valueOf(index))));
        }

        threadPoolExecutor.shutdown();


    }

}
