package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2022-01-08 21:56
 **/
public class InterruptRunnableDemo extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // ... 单次循环代码
            System.out.println("单次循环代码");
        }
        System.out.println("done ");
    }

    public static void main(String[] args) throws InterruptedException {
        //Thread thread = new InterruptRunnableDemo();
        //thread.start();
        //Thread.sleep(100);
        //thread.interrupt();
        Thread t = new Thread (){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(isInterrupted());
                }
            }
        };
        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        t.interrupt();
    }
}