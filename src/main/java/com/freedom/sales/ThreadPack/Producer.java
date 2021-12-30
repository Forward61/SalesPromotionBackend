package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 16:52
 **/
public  class Producer extends Thread{
    MyBlockingQueue <String> queue;
    public Producer(MyBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int num=0;
        try {
            while(true) {
                String task= String.valueOf(num);
                queue.put(task);
                System.out.println("生产者 produce task " + task);
                num++;
                Thread.sleep((int)(Math.random()*100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
