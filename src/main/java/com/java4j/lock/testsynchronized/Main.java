package com.java4j.lock.testsynchronized;

public class Main {

    public synchronized void say() {
        System.out.println(Thread.currentThread().getName() + " Begin Main says");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End Main says");
    }
}
