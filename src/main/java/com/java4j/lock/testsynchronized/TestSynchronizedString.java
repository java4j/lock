package com.java4j.lock.testsynchronized;

public class TestSynchronizedString {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> { synchronizedString(new String("123456")); });
        t1.start();
        Thread t2 = new Thread(() -> { synchronizedString(new String("123456")); });
        t2.start();
        Thread t3 = new Thread(() -> { synchronizedString(new String("123456")); });
        t3.start();
    }

    public static void synchronizedString(String s) {
        synchronized (s) {
            System.out.println("Begin synchronized string.");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End synchronized string.");
        }
    }
}
