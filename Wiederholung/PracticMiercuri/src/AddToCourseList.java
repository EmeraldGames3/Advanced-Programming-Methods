import java.util.ArrayList;

public class AddToCourseList {
    private final Object lock = new Object();

    public ArrayList<Student> addToList(ArrayList<Student> students) throws InterruptedException {
        Thread registrationThread = new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + " Added Student");
                        students.add(new Student(i, i, String.valueOf(i), i, String.valueOf(i)));
                        Thread.sleep(2000);
                        lock.notify();
                        lock.wait();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-1");

        Thread monitoringThread = new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        lock.wait();
                        System.out.println(Thread.currentThread().getName() + " Validate added Student");
                        if (students.getLast().getStudent_id() != i){
                            throw new RuntimeException("You dumb");
                        }
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-2");

        monitoringThread.start();
        registrationThread.start();

        monitoringThread.join();
        registrationThread.join();

        return students;
    }
}
