package com.java4j.lock.testsynchronized;

public class Sub extends Main {

    public static void main(String[] args) {
        Sub sub = new Sub();
        Thread t1 = new Thread(() -> sub.say());
        t1.start();

        Thread t2 = new Thread(() -> sub.say());
        t2.start();

        Thread t3 = new Thread(() -> sub.say());
        t3.start();
    }
}
