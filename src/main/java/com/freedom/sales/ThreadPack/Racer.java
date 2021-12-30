package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 17:34
 **/
public class Racer extends Thread{
    FireFlag fileFlage;
    public Racer(FireFlag fileFlage){
        this.fileFlage = fileFlage;
    }

    @Override
    public void run() {
        try {
            this.fileFlage.waitForFire();
            System.out.println("start run "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
