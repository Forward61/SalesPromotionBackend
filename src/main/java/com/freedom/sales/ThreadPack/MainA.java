package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 17:48
 **/
public class MainA {
    public static void main(String[] args) throws InterruptedException {
        int wokerNum=100;
        MyLatch latch = new MyLatch(wokerNum);
        Worker [] workers=new Worker[wokerNum];
        for (int i=0;i<wokerNum;i++) {
            workers[i]=new Worker(latch);
            workers[i].start();
        }
        latch.await();
        System.out.println("collet worker results");
    }
}
