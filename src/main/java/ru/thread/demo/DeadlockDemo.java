package ru.thread.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/** The type DeadlockDemo */
public class DeadlockDemo {

    private final Resource r1 = new Resource("R1");
    private final Resource r2 = new Resource("R2");

    public static void main(String[] args) {
        new DeadlockDemo().demo();
    }

    private void demo() {
        var t1 = new Thread(() -> action(r1, r2));
        t1.setName("t1");

        var t2 = new Thread(() -> action(r2, r1));
        t2.setName("t2");

        t1.start();
        t2.start();

        sleep();
        sleep();
        System.out.println("findDeadlockedThreads");
        long[] threads = ManagementFactory.getThreadMXBean().findDeadlockedThreads();
        if (threads != null) {
            ThreadInfo[] threadInfo = ManagementFactory.getThreadMXBean().getThreadInfo(threads);
            System.out.println("blocked threads: " + Arrays.toString(threadInfo));
        }
    }


    private static void action(
        Resource has,
        Resource need
    ) {
        // Доработка для избежания дедЛюка
        Resource first = has.getName().compareTo(need.getName()) > 0 ? has : need;
        Resource second = has.getName().compareTo(need.getName()) > 0 ? need : has;

        System.out.println(Thread.currentThread().getName() + " has: " + has);
        synchronized (first) {
            sleep();
            System.out.println(Thread.currentThread().getName() + " taking: " + need);
            synchronized (second) {
                System.out.println("taken by " + Thread.currentThread().getName());
                operation(has, need);
            }
        }
    }

    private static void operation(
        Resource has,
        Resource need
    ) {
        System.out.println("Make trans from " + has + " to "+ need);
    }

    private static void sleep() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static class Resource {
        private final String name;

        public String getName() {
            return name;
        }

        Resource(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Resource{" +
                "name='" + name + '\'' +
                '}';
        }
    }
}
