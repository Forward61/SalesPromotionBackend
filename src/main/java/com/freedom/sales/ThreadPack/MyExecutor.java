package com.freedom.sales.ThreadPack;

import java.util.concurrent.Callable;

/**
 * @Author: freedom
 * @Date: 2021-12-30 09:41
 **/
public class MyExecutor {
    //public <V> MyFuture<V> execute(final Callable<V> task) {
    //    return ;
    //}
    public <V> MyFuture<V> execute(final Callable<V> task) {
        final Object lock = new Object();
        final ExecuteThread<V> thread = new ExecuteThread<>(task, lock);
        thread.start();

        MyFuture<V> future = new MyFuture<V>() {
            @Override
            public V get() throws Exception {
                synchronized (lock) {
                    while (!thread.isDone()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    if (thread.getException() != null) {
                        throw thread.getException();
                    }
                    return thread.getResult();
                }
            }
        };
        return future;
    }
}
