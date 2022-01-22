package com.freedom.sales.ThreadPack;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: freedom
 * @Date: 2022-01-14 22:05
 **/
public class AtomicReferenceDemo {
    static class Pair {
        final private int first;
        final private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    public static void main(String[] args) {
        Pair p = new Pair(100, 200);
        AtomicReference<Pair> pairRef = new AtomicReference<>(p);
        pairRef.compareAndSet(p, new Pair(200, 200));

        System.out.println(pairRef.get().getFirst());
        System.out.println(pairRef.get().getSecond());

    }
}