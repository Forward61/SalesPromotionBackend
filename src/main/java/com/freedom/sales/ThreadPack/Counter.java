package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-28 10:22
 **/
public class Counter {
    private int count;
    public synchronized void incr(){
        count++;
    }
    public synchronized int  getCount(){
        return count;
    }
}
