package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-28 09:38
 **/
//竞态条件
public class CountThread extends Thread{
    private static  int counter=0;

    @Override
    public void run() {
        for(int i=0; i<1000;i++){
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num =1000;
        Thread [] threads = new CountThread[num];
        for(int i=0; i<threads.length; i++){
            threads[i] = new CountThread();
            threads[i].start();
        }
        for (int i=0;i<num;i++){
            threads[i].join();
        }
        System.out.println(counter);
    }
}
