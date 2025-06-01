
import java.util.*;
import java.util.stream.Collectors;

/**
 * StreamApiDemo
 *
 * This class demonstrates practical examples of using the Java Stream API.
 * It includes operations such as filtering, mapping, sorting, grouping,
 * aggregating, and collecting data from collections.
 *
 * Examples covered: -
 * Grouping employees by department and summing salaries
 * Find Even numbers using Stream API
 * Convert String to Uppercase and length more than 3
 *
 * Intended for educational and interview preparation purposes.
 */

public class StreamApiDemo {

    public static void main(String[] args) {

        // Find Even numbers using Stream API
        StreamApiDemo st = new StreamApiDemo();
        st.filterEvenNumber();

        // Convert String to Uppercase and length more than 3
        st.convertToUpperCase();

        // Find sum of salaries grouped by department
        st.findHighestSalary();
    }

    // Function to filter Even numbers from a list
    public void filterEvenNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(a -> a % 2 == 0)
                .forEach(System.out::println);
    }

    // Function to find char length more than three and convert to uppercase.
    public void convertToUpperCase() {
        List<String> names = Arrays.asList("Akshay", "Bob", "Sunny");

        List<String> result = names.stream()
                .filter(x -> x.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Result : " + result);
    }

    public void findHighestSalary() {

        List<Employee> employee = List.of(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "IT", 60000),
                new Employee("David", "HR", 55000),
                new Employee("Eva", "Finance", 75000)
        );

        Map<String, Double> salaryByDept = employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

        salaryByDept.forEach((department, salary)
                -> System.out.println("Department : " + department + " Salary : " + salary));

    }

    public class Employee {

        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
