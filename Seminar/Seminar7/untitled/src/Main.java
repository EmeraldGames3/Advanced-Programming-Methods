import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Employee bob = new Employee("bob", 100);
        Employee dob = new Employee("dob", 50);
        Employee cob = new Employee("cob", 75);

        List<Employee> employees = List.of(bob, dob, cob);

//        bob.employee_statistics(employees);

        Statistiks statistiks = new Statistiks(
                List.of(1, 2, 4, 7, 9, 11, 1, 1, 1, 1, 1, 1, 1, 1), 4);
//        statistiks.calculateStatistics();

        MatrixOperations matrixOperations = new MatrixOperations(
                List.of(List.of(1, 0, 0), List.of(0, 1, 0), List.of(0, 0, 1)),
                List.of(List.of(0, 1, 1), List.of(1, 0, 1), List.of(1, 1, 0)),
                4);

        matrixOperations.calculateSum();
        matrixOperations.calculateMultiplication();
    }
}