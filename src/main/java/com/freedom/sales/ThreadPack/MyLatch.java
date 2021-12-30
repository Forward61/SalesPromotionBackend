package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 17:44
 **/
public class MyLatch {
    private int count;
    public MyLatch(int count) {
        this.count = count;
    }
    public synchronized void await() throws InterruptedException {
        while(count > 0){
            wait();
        }
    }
    public synchronized void countDown(){
        count --;
        if(count <= 0){
            notifyAll();
        }
    }
}
