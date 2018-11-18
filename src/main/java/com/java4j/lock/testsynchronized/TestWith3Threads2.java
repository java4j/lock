package com.java4j.lock.testsynchronized;

public class TestWith3Threads2 {

    public static void main(String[] args) {
        User user = new User();
        Thread t1 = new Thread(() -> user.serviceA(), "Thread1");
        Thread t2 = new Thread(() -> user.serviceB(), "Thread2");
        Thread t3 = new Thread(() -> user.serviceA(), "Thread3");
        t1.start();
        t2.start();
        t3.start();
    }
}
