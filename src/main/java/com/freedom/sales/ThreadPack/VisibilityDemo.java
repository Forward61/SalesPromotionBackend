package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-28 09:50
 **/
public class VisibilityDemo  {
    //volatile内存可见性
    private static volatile boolean shutdown = false;

    static class HelloThread extends Thread{
        @Override
        public void run() {
            while (!shutdown) {


            }
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new HelloThread().start();
        Thread.sleep(1000);
        shutdown=true;
        System.out.println("exit main ");
    }
}
