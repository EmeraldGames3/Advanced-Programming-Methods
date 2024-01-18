package S7;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Employee[] employees = {
                new Employee("Alice", 70000),
                new Employee("Bob", 50000),
                new Employee("Charlie", 80000)
        };

        Calculator.employeeStatistics(employees);
        System.out.println();

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long sum = Statistics.calculateSum(numbers, 4);
        long max = Statistics.calculateMax(numbers, 4);
        System.out.println("Summe: " + sum);
        System.out.println("Max: " + max);

        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};

        int[][] sumM = MatrixManipulation.calculateMatrixSum(matrix1, matrix2);
        int[][] productM = MatrixManipulation.calculateMatrixProduct(matrix1, matrix2);

        System.out.println("Sum:");
        printMatrix(sumM);

        System.out.println("Product:");
        printMatrix(productM);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}