package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-30 10:26
 **/
public class AssemblePointDemo {
    static class Tourist extends Thread{
        AssemblePoint ap;

        public Tourist(AssemblePoint ap){
            this.ap = ap;
        }

        @Override
        public void run() {
            //模拟先各自独立运行
            try {
                Thread.sleep((int)(Math.random() * 1000));
                //集合
                ap.await();
                System.out.println("arrived到达"+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int num=10;
        Tourist [] threads= new Tourist[num];
        AssemblePoint ap = new AssemblePoint(num);
        for (int i = 0; i < num; i++) {
            threads[i]= new Tourist(ap);
            threads[i].start();
        }
    }
}
