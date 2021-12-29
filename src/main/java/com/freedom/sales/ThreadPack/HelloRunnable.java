package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-26 00:16
 **/
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello runnable thread name: "+ Thread.currentThread().getName());
        System.out.println("Hello Runnable run");
    }
}
