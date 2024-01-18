package S7;

import java.util.Arrays;

public class Calculator {
    public static void employeeStatistics(Employee[] emps){
        Thread maxThread = new Thread(() -> {
            int max = Arrays.stream(emps)
                    .mapToInt(Employee::getGehalt)
                    .max().
                    orElse(0);
            System.out.println("Max Salary: " + max);
        });

        Thread minThread = new Thread(() -> {
            int min = Arrays.stream(emps)
                    .mapToInt(Employee::getGehalt)
                    .min()
                    .orElse(0);
            System.out.println("Min Salary: " + min);
        });

        Thread avgThread = new Thread(() -> {
            double avg = Arrays.stream(emps)
                    .mapToInt(Employee::getGehalt)
                    .average()
                    .orElse(0);
            System.out.println("Avarage Salary: " + avg);
        });

        Thread sumThread = new Thread(() -> {
            int sum = Arrays.stream(emps)
                    .mapToInt(Employee::getGehalt)
                    .sum();
            System.out.println("Sum of Sallaries: " + sum);
        });

        maxThread.start();
        minThread.start();
        avgThread.start();
        sumThread.start();

        try {
            maxThread.join();
            minThread.join();
            avgThread.join();
            sumThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
