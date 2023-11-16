import java.util.ArrayList;
import java.util.List;

public class MatrixOperations {
    List<List<Integer>> matrix1;
    List<List<Integer>> matrix2;
    int threadNumber;

    public MatrixOperations(List<List<Integer>> matrix1, List<List<Integer>> matrix2, int threadNumber) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.threadNumber = threadNumber;
    }

    public void calculateSum() throws InterruptedException {
        int rows = matrix1.size();
        int elementsPerThread = rows / threadNumber;
        int remainingRows = rows % threadNumber;

        Thread[] threads = new SumThread[threadNumber];
        int startRow = 0;

        for (int i = 0; i < threadNumber; i++) {
            int extraRow = (i < remainingRows) ? 1 : 0;
            int endRow = startRow + elementsPerThread + extraRow;

            threads[i] = new SumThread(startRow, endRow, matrix1, matrix2);
            threads[i].start();
            startRow = endRow;
        }

        for (Thread thread : threads) {
            thread.join();
        }

        List<List<Integer>> totalSum = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            totalSum.add(new ArrayList<>(matrix1.get(0).size()));
        }

        for (Thread thread : threads) {
            List<List<Integer>> threadSum = ((SumThread) thread).getLocalSum();
            for (int i = ((SumThread) thread).startRow; i < ((SumThread) thread).endRow; i++) {
                totalSum.set(i, threadSum.get(i - ((SumThread) thread).startRow));
            }
        }

        System.out.println("Sum of matrices:");
        for (List<Integer> row : totalSum) {
            System.out.println(row);
        }
    }

    public void calculateMultiplication() throws InterruptedException {
        int rows = matrix1.size();
        int cols = matrix2.get(0).size();
        int elementsPerThread = rows / threadNumber;
        int remainingRows = rows % threadNumber;

        Thread[] threads = new MultiplyThread[threadNumber];
        int startRow = 0;

        for (int i = 0; i < threadNumber; i++) {
            int extraRow = (i < remainingRows) ? 1 : 0;
            int endRow = startRow + elementsPerThread + extraRow;

            threads[i] = new MultiplyThread(startRow, endRow, matrix1, matrix2);
            threads[i].start();
            startRow = endRow;
        }

        for (Thread thread : threads) {
            thread.join();
        }

        List<List<Integer>> totalMultiplication = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            totalMultiplication.add(new ArrayList<>(cols));
        }

        for (Thread thread : threads) {
            List<List<Integer>> threadMultiplication = ((MultiplyThread) thread).getMultiplicationResult();
            for (int i = ((MultiplyThread) thread).startRow; i < ((MultiplyThread) thread).endRow; i++) {
                totalMultiplication.set(i, threadMultiplication.get(i - ((MultiplyThread) thread).startRow));
            }
        }

        // Print or use the result matrix
        System.out.println("Multiplication of matrices:");
        for (List<Integer> row : totalMultiplication) {
            System.out.println(row);
        }
    }

    public class SumThread extends Thread {
        public List<List<Integer>> matrix1;
        public List<List<Integer>> matrix2;
        public List<List<Integer>> localSum;
        private int startRow;
        private int endRow;

        public SumThread(int startRow, int endRow, List<List<Integer>> matrix1, List<List<Integer>> matrix2) {
            this.startRow = startRow;
            this.endRow = endRow;
            this.localSum = new ArrayList<>();
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;

            int rows = matrix1.size();
            int cols = matrix1.get(0).size();

            for (int i = 0; i < rows; i++) {
                ArrayList<Integer> rowSum = new ArrayList<>();
                for (int j = 0; j < cols; j++) {
                    rowSum.add(0);
                }
                localSum.add(rowSum);
            }
        }

        public void run() {
            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < matrix1.get(0).size(); j++) {
                    int sum = matrix1.get(i).get(j) + matrix2.get(i).get(j);
                    localSum.get(i - startRow).set(j, sum);
                }
            }
        }

        public List<List<Integer>> getLocalSum() {
            return localSum;
        }
    }

    public class MultiplyThread extends Thread {
        private int startRow;
        private int endRow;
        private List<List<Integer>> matrix1;
        private List<List<Integer>> matrix2;
        private List<List<Integer>> multiplication;

        public MultiplyThread(int startRow, int endRow, List<List<Integer>> matrix1, List<List<Integer>> matrix2) {
            this.startRow = startRow;
            this.endRow = endRow;
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.multiplication = new ArrayList<>();

            int cols = matrix2.get(0).size();

            for (int i = 0; i < endRow - startRow; i++) {
                multiplication.add(new ArrayList<>(cols));
                for (int j = 0; j < cols; j++) {
                    multiplication.get(i).add(0);
                }
            }
        }

        public void run() {
            int cols1 = matrix1.get(0).size();
            int cols2 = matrix2.get(0).size();
            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < cols2; j++) {
                    int sum = 0;
                    for (int k = 0; k < cols1; k++) {
                        sum += matrix1.get(i).get(k) * matrix2.get(k).get(j);
                    }
                    multiplication.get(i - startRow).set(j, sum);
                }
            }
        }

        public List<List<Integer>> getMultiplicationResult() {
            return multiplication;
        }
    }
}