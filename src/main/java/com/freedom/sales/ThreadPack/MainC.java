package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 17:36
 **/
public class MainC {
    public static void main(String[] args) throws InterruptedException {
        int num =10;
        FireFlag fileFlage = new FireFlag();
        Thread [] racers = new Thread[num];
        for(int i = 0; i < num; i++){
            racers[i]=new Racer(fileFlage);
            racers[i].start();
        }
        Thread.sleep(1000);
        fileFlage.fire();
    }

}
