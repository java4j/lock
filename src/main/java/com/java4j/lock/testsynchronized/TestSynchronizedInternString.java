package com.java4j.lock.testsynchronized;

public class TestSynchronizedInternString {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> { synchronizedInternString(new String("123456")); });
        t1.start();
        Thread t2 = new Thread(() -> { synchronizedInternString(new String("123456")); });
        t2.start();
        Thread t3 = new Thread(() -> { synchronizedInternString(new String("123456")); });
        t3.start();
    }

    public static void synchronizedInternString(String s) {
        synchronized (s.intern()) {
            System.out.println("Begin synchronized intern string.");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End synchronized intern string.");
        }
    }
}
