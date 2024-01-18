package S7;

public class MatrixManipulation {
    public static class MatrixProductThread extends Thread {
        private final int[][] matrix1;
        private final int[][] matrix2;
        private final int[][] productMatrix;
        private final int row;

        public MatrixProductThread(int[][] matrix1, int[][] matrix2, int[][] productMatrix, int row) {
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.productMatrix = productMatrix;
            this.row = row;
        }

        @Override
        public void run() {
            for (int i = 0; i < matrix2[0].length; i++) {
                for (int j = 0; j < matrix1[row].length; j++) {
                    productMatrix[row][i] += matrix1[row][j] * matrix2[j][i];
                }
            }
        }
    }


    public static class MatrixSumThread extends Thread {
        private final int[][] matrix1;
        private final int[][] matrix2;
        private final int[][] sumMatrix;
        private final int row;

        public MatrixSumThread(int[][] matrix1, int[][] matrix2, int[][] sumMatrix, int row) {
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.sumMatrix = sumMatrix;
            this.row = row;
        }

        @Override
        public void run() {
            for (int i = 0; i < matrix1[row].length; i++) {
                sumMatrix[row][i] = matrix1[row][i] + matrix2[row][i];
            }
        }
    }


    public static int[][] calculateMatrixSum(int[][] matrix1, int[][] matrix2) throws InterruptedException {
        int rows = matrix1.length;
        int[][] sumMatrix = new int[rows][matrix1[0].length];
        MatrixSumThread[] threads = new MatrixSumThread[rows];

        for (int i = 0; i < rows; i++) {
            threads[i] = new MatrixSumThread(matrix1, matrix2, sumMatrix, i);
            threads[i].start();
        }

        for (MatrixSumThread thread : threads) {
            thread.join();
        }

        return sumMatrix;
    }

    public static int[][] calculateMatrixProduct(int[][] matrix1, int[][] matrix2) throws InterruptedException {
        int rows = matrix1.length;
        int[][] productMatrix = new int[rows][matrix2[0].length];
        MatrixProductThread[] threads = new MatrixProductThread[rows];

        for (int i = 0; i < rows; i++) {
            threads[i] = new MatrixProductThread(matrix1, matrix2, productMatrix, i);
            threads[i].start();
        }

        for (MatrixProductThread thread : threads) {
            thread.join();
        }

        return productMatrix;
    }
}
