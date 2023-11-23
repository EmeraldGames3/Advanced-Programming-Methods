import java.util.LinkedList;
import java.util.Queue;

public class ParallelQueue {
    private final Queue<Integer> queue;

    public ParallelQueue() {
        this.queue = new LinkedList<>();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized void enqueue(int element) {
        this.queue.add(element);
        notify();
    }

    public synchronized int dequeue() throws InterruptedException {
        while (queue.isEmpty())
            wait();
        return queue.poll();
    }
}