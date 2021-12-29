package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-25 22:54
 **/
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new HelloThread();
        thread.run();
        thread.start();
        thread.join();
        Thread threadRunnable = new Thread(new HelloRunnable());
        threadRunnable.start();


    }

}
