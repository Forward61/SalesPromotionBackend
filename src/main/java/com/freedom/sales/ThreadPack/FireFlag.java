package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 17:27
 **/
public class FireFlag {
    private volatile boolean fired = false;
    public synchronized void waitForFire() throws InterruptedException{
        while(!fired){
            wait();
        }
    }
    public synchronized void fire(){
        this.fired = true;
        System.out.println("fired是true了");
        notifyAll();
    }
}
