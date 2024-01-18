import java.util.Objects;

public class AnimalMonitor {
    public void animalHealth(Animal animal) throws InterruptedException {
        final Object lock = new Object();

        Thread doctorThread = new Thread(() -> {
            Thread.currentThread().setName("Doctor");
            try {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        while (Objects.equals(animal.getHealth_status(), "Healthy"))
                            lock.wait();
                        animal.setHealth_status("Healthy");
                        System.out.println(Thread.currentThread().getName() + ": Made animal " + animal.getHealth_status() + " and waited 2 seconds");
                        Thread.sleep(2000);
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
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        while (Objects.equals(animal.getHealth_status(), "Sick"))
                            lock.wait();

                        animal.setHealth_status("Sick");
                        System.out.println(Thread.currentThread().getName() + ": Made animal "
                                + animal.getHealth_status());
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        diseaseThread.start();
        doctorThread.start();

        doctorThread.join();
        diseaseThread.join();
    }
}
