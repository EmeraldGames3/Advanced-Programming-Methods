package S7;

public class Statistics {
    private static class SummationThread extends Thread {
        private final int[] numbers;
        private final int start;
        private final int end;
        private long sum = 0;

        public SummationThread(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
        }

        public long getSum() {
            return sum;
        }
    }

    private static class MaxThread extends Thread {
        private final int[] numbers;
        private final int start;
        private final int end;
        private long max = Integer.MIN_VALUE;

        public MaxThread(int[] numbers, int start, int end){
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                if(numbers[i] > max)
                    max = numbers[i];
            }
        }

        long getMax(){
            return this.max;
        }
    }

    public static long calculateSum(int[] numbers, int threadCount) throws InterruptedException {
        int partSize = numbers.length / threadCount;
        SummationThread[] threads = new SummationThread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int start = i * partSize;
            int end = (i == threadCount - 1) ? numbers.length : start + partSize;
            threads[i] = new SummationThread(numbers, start, end);
            threads[i].start();
        }

        long totalSum = 0;
        for (SummationThread thread : threads) {
            thread.join();
            totalSum += thread.getSum();
        }

        return totalSum;
    }

    public static long calculateMax(int[] numbers, int threadCount) throws InterruptedException {
        int partSize = numbers.length / threadCount;
        MaxThread[] threads = new MaxThread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int start = i * partSize;
            int end = (i == threadCount - 1) ? numbers.length : start + partSize;
            threads[i] = new MaxThread(numbers, start, end);
            threads[i].start();
        }

        long max = Long.MIN_VALUE;
        for (MaxThread thread : threads) {
            thread.join();
            max = Math.max(max, thread.getMax());
        }

        return max;
    }
}
