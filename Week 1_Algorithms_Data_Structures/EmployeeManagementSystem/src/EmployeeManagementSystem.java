import java.util.*;
class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        }
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + employees[i].getEmployeeId() + ", Name: " + employees[i].getName());
        }
    }

    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline

        EmployeeManagementSystem ems = new EmployeeManagementSystem(n);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Id:");
            String employeeId = sc.nextLine();
            System.out.println("Name:");
            String name = sc.nextLine();
            System.out.println("Position:");
            String position = sc.nextLine();
            System.out.println("Salary:");
            double salary = sc.nextDouble();
            sc.nextLine(); // Consume the newline
            ems.addEmployee(new Employee(employeeId, name, position, salary));
        }

        System.out.println("Traverse Employees:");
        ems.traverseEmployees();

        System.out.println("Search Employee:");
        System.out.println("Enter EmployeeId:");
        String employeeId = sc.nextLine();
        Employee emp = ems.searchEmployee(employeeId);
        System.out.println("Found: " + (emp != null ? emp.getName() : "null"));

        System.out.println("Delete Employee:");
        System.out.println("Enter EmployeeId:");
        employeeId = sc.nextLine();
        ems.deleteEmployee(employeeId);
        ems.traverseEmployees();
        
        sc.close(); // Close the scanner
    }
}
