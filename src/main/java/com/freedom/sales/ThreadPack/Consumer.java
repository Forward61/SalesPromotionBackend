package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-29 17:00
 **/
 public class Consumer extends Thread{
    MyBlockingQueue<String> queue;
    public Consumer(MyBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                String task=queue.take();
                System.out.println("consumer消费者 handle task" + task);
                Thread.sleep((int)(Math.random() * 100));

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
