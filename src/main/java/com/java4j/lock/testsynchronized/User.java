package com.java4j.lock.testsynchronized;

import java.util.concurrent.TimeUnit;

public class User {
    public synchronized void serviceA() {
        System.out.println(Thread.currentThread().getName() + " Begin serviceA.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End serviceA.");
    }

    public void serviceB() {
        System.out.println(Thread.currentThread().getName() + " Begin serviceB.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End serviceB.");
    }
}
