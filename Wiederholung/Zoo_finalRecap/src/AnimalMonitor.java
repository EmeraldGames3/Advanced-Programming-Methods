public class AnimalMonitor {
    public static void MonitorAnimals(Animal animal){
        Object lock = new Object();

        Thread doctorThread = new Thread(() -> {
            while (true){
                try {
                    synchronized (lock) {
                        while (animal.getHealth_status().equals("Healthy")) {
                            lock.wait();
                        }
                        animal.setHealth_status("Healthy");
                        System.out.println(Thread.currentThread().getName());
                        lock.notify();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Doctor");

        Thread diseaseThread = new Thread(() -> {
            while (true){
                try {
                    synchronized (lock) {
                        while (animal.getHealth_status().equals("Sick"))
                            lock.wait();
                        animal.setHealth_status("Sick");
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(2000);
                        lock.notify();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        },"Disease");


        diseaseThread.start();
        doctorThread.start();

        try {
            doctorThread.join();
            diseaseThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
