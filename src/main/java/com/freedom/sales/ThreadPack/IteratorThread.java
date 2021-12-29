package com.freedom.sales.ThreadPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: freedom
 * @Date: 2021-12-29 15:59
 **/
public class IteratorThread {
    private static void startModifyThread(final List<String> list){
        Thread modifyThread = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0; i<100;i++){
                    list.add("item  "+i);
                }
                try {
                    Thread.sleep((int)(Math.random()*10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        modifyThread.start();
    }
    private static void startIteratorThread(final List<String> list) {
        Thread iteratoreThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    synchronized (list) {//遍历的同时容器发生了结构性变化,就会抛出异常,
                        //同步容器并没有解决这个问题,如果要避免这个异常,需要在遍历的时候给整个容器对象加锁,如list
                        for(String str:list){
                            System.out.println("  "+str);
                        }
                    }

                }
            }
        });
        iteratoreThread.start();
    }

    public static void main(String[] args) {
        final List<String> list = Collections.synchronizedList(new ArrayList<String>());
        startIteratorThread(list);
        startModifyThread(list);
    }
}
