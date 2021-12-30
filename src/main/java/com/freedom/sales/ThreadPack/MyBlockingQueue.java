package com.freedom.sales.ThreadPack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: freedom
 * @Date: 2021-12-29 16:52
 **/
public class MyBlockingQueue<E> {
    private Queue<E> queue=null;
    private int limit;
    public MyBlockingQueue(int limit) throws InterruptedException {
        this.limit=limit;
        queue=new ArrayDeque<E>();


    }
    public synchronized void put(E e) throws InterruptedException {
        while(queue.size()==limit) {
            wait();
        }
        queue.add(e);
        notifyAll();
    }
    public synchronized E take() throws InterruptedException {
        while(queue.isEmpty()) {
            wait();
        }
        E e = queue.poll();
        notifyAll();
        return e;
    }
}
