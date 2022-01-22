package com.freedom.sales.ThreadPack;

import java.io.IOException;

/**
 * @Author: freedom
 * @Date: 2022-01-08 22:13
 **/
public class InterruptReadDemo {
    private static class A extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println(System.in.read());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("exit");
        }

        public void cancel() {
            try {
                System.in.close();
            } catch (IOException e) {
            }
            interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A t = new A();
        t.start();
        Thread.sleep(100);

        t.cancel();
        //AtomicInteger
    }
}
//public class InterruptReadDemo {
//    private static class A extends Thread {
//        @Override
//        public void run() {
//            while(!Thread.currentThread().isInterrupted()){
//                try {
//                    System.out.println(System.in.read());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("exit");
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        A t = new A();
//        t.start();
//        Thread.sleep(100);
//
//        t.interrupt();
//    }
//}