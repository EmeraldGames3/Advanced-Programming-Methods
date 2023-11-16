import java.util.List;

public class Employee {
    private String name;
    private Integer gehalt;

    public Employee(String name, Integer gehalt) {
        this.name = name;
        this.gehalt = gehalt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGehalt() {
        return gehalt;
    }

    public void setGehalt(Integer gehalt) {
        this.gehalt = gehalt;
    }

    public void employee_statistics(List<Employee> employees) throws InterruptedException {
        Thread maxSalaryCalculator = new MaxSalaryCalculator(employees);
        Thread avarageSalaryCalculator = new AvarageSalaryCalculator(employees);

        maxSalaryCalculator.start();
        maxSalaryCalculator.join();
        avarageSalaryCalculator.start();
        avarageSalaryCalculator.join();

        System.out.println(((MaxSalaryCalculator) maxSalaryCalculator).getEmployeeList());
        System.out.println(((AvarageSalaryCalculator) maxSalaryCalculator).getEmployeeList());
    }

    public class MaxSalaryCalculator extends Thread {

        private List<Employee> employeeList;
        private int maxGahalt;

        public MaxSalaryCalculator(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public void setEmployeeList(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }

        public int getMaxGahalt() {
            return maxGahalt;
        }

        public void setMaxGahalt(int maxGahalt) {
            this.maxGahalt = maxGahalt;
        }

        @Override
        public void run() {
            int max = Integer.MIN_VALUE;

            for (Employee employee : this.employeeList) {
                if (max < employee.gehalt) {
                    max = employee.gehalt;
                }
            }

            this.maxGahalt = max;
        }
    }

    public class AvarageSalaryCalculator extends Thread{
        private List<Employee> employeeList;
        private int avarageGahalt;

        public AvarageSalaryCalculator(List<Employee> employeeList) {
            this.employeeList = employeeList;
            this.avarageGahalt = 0;
        }

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public void setEmployeeList(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }

        public int getAvarageGahalt() {
            return avarageGahalt;
        }

        public void setAvarageGahalt(int avarageGahalt) {
            this.avarageGahalt = avarageGahalt;
        }

        @Override
        public void run() {
            int sum = 0;

            for (Employee employee : this.employeeList) {
                sum += employee.gehalt;
            }

            this.avarageGahalt = sum / this.employeeList.size();
        }
    }
}
