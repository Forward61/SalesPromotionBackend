package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-25 22:51
 **/
public class HelloThread extends Thread{

    @Override
    public void run() {
        System.out.println("thrad name :" + Thread.currentThread().getName());
        System.out.println("hello thread run 方法");
    }
}
