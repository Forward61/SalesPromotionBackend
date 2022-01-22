package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2022-01-01 22:45
 **/
public class InterruptSynchronizedDemo {
    private static Object lock=new Object();
    private static class A extends Thread{
        @Override
        public void run() {
            synchronized(lock) {
                while (!Thread.currentThread().isInterrupted()){

                }
            }
            System.out.println("exit了");
        }
    }

    public static  void test() throws InterruptedException {
        synchronized(lock) {
            A a= new A();
            a.start();
            Thread.sleep(1000);
            a.interrupt();
            a.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
