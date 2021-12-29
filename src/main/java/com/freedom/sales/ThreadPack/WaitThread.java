package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 16:24
 **/
public class WaitThread extends Thread{
    private volatile boolean fire=false;

    @Override
    public void run() {
        try {
            synchronized(this){
                while(!fire){
                    wait();
                }
            }
            System.out.println("fired");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void fire() {
        this.fire = true;
        notify();

    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread thread = new WaitThread();
        thread.start();
        Thread.sleep(10000);
        System.out.println("fire");
        thread.fire();
    }
}
