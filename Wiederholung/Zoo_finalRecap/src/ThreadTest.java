public class ThreadTest {
    public static void twoThreads() {
        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            while (true){
                try {
                    synchronized (lock){
                        lock.wait();
                        System.out.println(Thread.currentThread().getName());
                        lock.notify();
                    }
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }, "Thread1");
        Thread thread2 = new Thread(() -> {
            while (true){
                try {
                    synchronized (lock){
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(2000);
                        lock.notify();
                        lock.wait();
                    }
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }, "Thread2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
