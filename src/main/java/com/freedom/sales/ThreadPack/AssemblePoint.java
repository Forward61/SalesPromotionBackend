package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2021-12-30 10:24
 **/
public class AssemblePoint {
    private int n;
    public AssemblePoint(int n){
        this.n=n;
    }

    public synchronized void await() throws InterruptedException {
        if (n>0){
            n--;
            if(n==0){
                notifyAll();
            }else{
                while(n!=0){
                    wait();
                }
            }
        }
    }
}
