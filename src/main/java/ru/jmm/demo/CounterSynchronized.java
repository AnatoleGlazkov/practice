package ru.jmm.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CounterSynchronized {

    Logger log = LoggerFactory.getLogger(CounterSynchronized.class);

    private int count = 0;
    private static final int LIMIT = 100_000_000;
    private final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        var counter = new CounterSynchronized();
        counter.go();
    }

    /*
        private synchronized void inc() {
            for (var idx = 0; idx < LIMIT; idx++) {
                count++;
            }
        }


        private void inc() {
            synchronized (this) {
                for (var idx = 0; idx < LIMIT; idx++) {
                    count++;
                }
            }
        }
    */
    private void inc() {
        synchronized (monitor) {
            for (var idx = 0; idx < LIMIT; idx++) {
                count++;
            }
        }
    }

    private void go() throws InterruptedException {
        var thread1 = new Thread(this::inc);
        var thread2 = new Thread(this::inc);
        var thread3 = new Thread(this::inc);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        log.info("CounterBroken:{}", count);
    }
}

