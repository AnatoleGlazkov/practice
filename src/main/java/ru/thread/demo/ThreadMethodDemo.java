package ru.thread.demo;

import java.util.concurrent.TimeUnit;

/** The type ThreadMethodDemo */
public class ThreadMethodDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("starting");

        var thread = new Thread(
            () -> {
                var stop = false;
                while (!stop) {
                    System.out.printf("I am: %s state: %s%n", Thread.currentThread().getName(), Thread.currentThread().getState());
                    stop = sleepAndStop();
                    Thread.onSpinWait(); // "новая фича"
                }
            });
        thread.setName("Named-thread");
        thread.setDaemon(false);
        System.out.printf("state: %s%n", thread.getState());

        thread.start();

        sleep();
        System.out.println("interrupting");
        thread.interrupt();

        thread.join();

        System.out.println("finished");
    }

    private static boolean sleepAndStop() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            return false;
        } catch (InterruptedException e) {
            System.out.println("somebody is trying to stop us, Ok");
            Thread.currentThread().interrupt();
            return true;
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
