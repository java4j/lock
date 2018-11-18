package com.java4j.testsynchronized;

import java.util.concurrent.TimeUnit;

public class Demo {

    public void service() {
        System.out.println(Thread.currentThread().getName() + " Begin.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread t1 = new Thread(() -> demo.service(), "Thread1");
        Thread t2 = new Thread(() -> demo.service(), "Thread2");
        t1.start();
        t2.start();
    }
}
