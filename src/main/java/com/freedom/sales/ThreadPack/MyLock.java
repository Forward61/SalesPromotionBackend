package com.freedom.sales.ThreadPack;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: freedom
 * @Date: 2022-01-14 22:03
 **/
public class MyLock {
    private AtomicInteger status = new AtomicInteger(0);

    public void lock() {
        while (!status.compareAndSet(0, 1)) {
            Thread.yield();
        }
    }

    public void unlock() {
        status.compareAndSet(1, 0);
    }
}