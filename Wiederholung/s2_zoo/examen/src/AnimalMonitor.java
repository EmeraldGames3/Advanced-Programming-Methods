public class AnimalMonitor {
    public void animalHealth(Animal animal) throws InterruptedException {
        final Object lock = new Object();

        Thread doctorThread = new Thread(() -> {
            try {
                while (true) {
                    synchronized (lock) {
                        while (animal.getHealth_status().equals("Healthy"))
                            lock.wait();
                        animal.setHealth_status("Healthy");
                        System.out.println(Thread.currentThread().getName() + " " + animal.getHealth_status());
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Doctor");

        Thread diseaseThread = new Thread(() -> {
            try {
                while (true) {
                    synchronized (lock) {
                        while (animal.getHealth_status().equals("Sick"))
                            lock.wait();
                        animal.setHealth_status("Sick");
                        System.out.println(Thread.currentThread().getName() + " " + animal.getHealth_status());
                        Thread.sleep(2000);
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Disease");

        diseaseThread.start();
        doctorThread.start();

        doctorThread.join();
        diseaseThread.join();
    }
}
