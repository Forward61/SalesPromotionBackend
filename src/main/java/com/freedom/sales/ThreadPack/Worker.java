package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 17:47
 **/
public class Worker extends Thread{
    MyLatch latch;
    public Worker(MyLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 1000));
            this.latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
