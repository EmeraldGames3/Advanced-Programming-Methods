import java.util.List;

public class Statistiks {
    public List<Integer> numbers;
    public int threadNumber;

    public Statistiks(List<Integer> numbers, int threadNumber) {
        this.numbers = numbers;
        this.threadNumber = threadNumber;
    }

    public void calculateStatistics() throws InterruptedException {
        WorkerThread[] threads = new WorkerThread[threadNumber];
        int chunkSize = numbers.size() / threadNumber;
        int start = 0;
        int end;

        for (int i = 0; i < threadNumber; i++) {
            end = (i == threadNumber - 1) ? numbers.size() : start + chunkSize;
            threads[i] = new WorkerThread(start, end);
            threads[i].start();
            start = end;
        }

        for (WorkerThread thread : threads) {
            thread.join();
        }

        int totalSum = 0;
        int totalMax = Integer.MIN_VALUE;

        for (WorkerThread thread : threads) {
            totalSum += thread.localSum;
            totalMax = Math.max(totalMax, thread.localMax);
        }

        System.out.println("Total Sum: " + totalSum);
        System.out.println("Maximum Value: " + totalMax);
    }

    public class WorkerThread extends Thread {
        public int start;
        public int end;
        public int localSum;
        public int localMax;

        public WorkerThread(int start, int end) {
            this.start = start;
            this.end = end;
            this.localSum = 0;
            this.localMax = Integer.MIN_VALUE;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                int num = numbers.get(i);
                this.localSum += num;
                this.localMax = Math.max(localMax, num);
            }
        }
    }
}
