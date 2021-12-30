package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 17:02
 **/
public class MainT<queue> {
    //MyBlockingQueue<String> queue;
    //queue=new MyBlockingQueue<>(10);




    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue=new MyBlockingQueue<>(10);

        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
