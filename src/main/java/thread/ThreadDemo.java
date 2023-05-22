package thread;

/**
 * The type ThreadFirst
 * <p>
 * {@link <a href="https://otus.ru/learning/145807/">...</a>}
 */
public class ThreadDemo {


    public static void main(String... args) {
//        case1();
        case2();
    }

    private static void case1() {
        System.out.println("Main program started: " + Thread.currentThread().getName());

        var thread = new Thread(() -> System.out.println("from thread: " + Thread.currentThread().getName()));
        thread.start();

        System.out.println("Main program finished: " + Thread.currentThread().getName());
    }

    private static void case2() {

        System.out.println("Main program started: " + Thread.currentThread().getName());

        var thread = new CustomThread();
        thread.start();

        System.out.println("Main program finished: " + Thread.currentThread().getName());
    }

    private static class CustomThread extends Thread {
        @Override
        public void run() {
            System.out.println("From thread: " + Thread.currentThread().getName());
        }
    }

}
