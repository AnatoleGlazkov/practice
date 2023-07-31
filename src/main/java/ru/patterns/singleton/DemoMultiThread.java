package ru.patterns.singleton;

/** The type DemoMultiThread */
public class DemoMultiThread {

    public static void main(String[] args) {

        String s = "Hello world";

        String other = "Hello " + "world";

        System.out.println("""
            If you see the same value, then singleton was reused (yay!)
            If you see different values, then 2 singletons were created (booo!!)
            RESULT:
            """);
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            SingletonOther singleton = SingletonOther.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            SingletonOther singleton = SingletonOther.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }

}
