public class AnimalMonitor {
    public void animalHealth(Animal animal) throws InterruptedException {
        final Object lock = new Object();

        Thread doctorThread = new Thread(() -> {
            Thread.currentThread().setName("Doctor");
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock) {
                        while (!animal.getHealth_status().equals("Sick")) {
                            lock.wait();
                        }
                        animal.setHealth_status("Healthy");
                        System.out.println(Thread.currentThread().getName() + ": Animal cured");
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread diseaseThread = new Thread(() -> {
            Thread.currentThread().setName("Disease");
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + ": wait 2 seconds");
                        Thread.sleep(2000);
                        animal.setHealth_status("Sick");
                        System.out.println(Thread.currentThread().getName() + ": Animal made sick");
                        lock.notify();
                        if (i < 4) {
                            lock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        doctorThread.start();
        diseaseThread.start();

        doctorThread.join();
        diseaseThread.join();
    }
}
