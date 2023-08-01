package ru.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {

        // Создание семафора с 3 разрешениями
        Semaphore semaphore = new Semaphore(3);

        // Потоки запрашивают разрешение у семафора
        Thread thread1 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 1 acquired the semaphore.");
                Thread.sleep(2000);
                System.out.println("Thread 1 released the semaphore.");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 2 acquired the semaphore.");
                Thread.sleep(2000);
                System.out.println("Thread 2 released the semaphore.");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 3 acquired the semaphore.");
                Thread.sleep(2000);
                System.out.println("Thread 3 released the semaphore.");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Запуск потоков
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
