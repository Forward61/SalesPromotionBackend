package com.freedom.sales.ThreadPack;

import java.util.concurrent.Callable;

/**
 * @Author: freedom
 * @Date: 2021-12-30 09:44
 **/
public class MainCallable {

    public static void main(String[] args) {
        MyExecutor myExecutor = new MyExecutor();
        Callable<Integer> subTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int millis=(int)(Math.random() * 1000);
                Thread.sleep(millis);
                return millis;
            }
        };
        MyFuture<Integer> future = myExecutor.execute(subTask);
        try {
            Integer result = future.get();
            System.out.println(" future.get()获取的值:" +result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
