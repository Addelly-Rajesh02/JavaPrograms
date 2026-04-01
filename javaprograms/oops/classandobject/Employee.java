package oops.classandobject;

import java.util.Scanner;

public class Employee
{
    private String name;    // Instance variables (non-static)
    private float salary;   // Instance variables (non-static)

    public Employee(String name, float salary)     // Constructor
    {
        this.name = name;
        this.salary = salary;
    }

    // getters method
    public String getName() { return name; }
    public float getSalary() { return salary; }

    // setters method
    public void setName(String name) { this.name = name; }
    public void setSalary(float salary) { this.salary = salary; }

    // Instance method
    public void displayDetails() {
        System.out.print("Employee: " + name);
        System.out.print("    Salary: " + salary);
    }

    public Employee() {
    }

    public static void main(String[] args)
    {
        Employee emp1 = new Employee("Rajesh", 10000.0f);
        Employee emp2 = new Employee("Shalini", 100000.0f);
        emp1.displayDetails();
        System.out.println();
        emp2.displayDetails();

        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<5;i++) {
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter salary");
            float salary = scanner.nextFloat();
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSalary(salary);
            employee.displayDetails();
        }
    }
}