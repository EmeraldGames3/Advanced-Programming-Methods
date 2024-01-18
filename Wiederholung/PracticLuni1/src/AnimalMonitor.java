public class AnimalMonitor {
    public void monitorAnimal(Animal animal) throws InterruptedException {
        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            Thread.currentThread().setName("Doctor");
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock) {
                        while (!animal.getHealth_status().equals("Sick"))
                            lock.wait();
                        animal.setHealth_status("Healthy");
                        System.out.println(Thread.currentThread().getName() + ": Animal cured");
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName("Disease");
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + ": wait for two seconds");
                        Thread.sleep(2000);
                        animal.setHealth_status("Sick");
                        System.out.println(Thread.currentThread().getName() + ": Animal made sick");
                        lock.notify();
                        lock.wait();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

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
