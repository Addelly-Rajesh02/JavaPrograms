package oops;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        List<Employee> employees=EmployeeData.get();

        System.out.println("Employees list: ");
        //print list of all employees
        employees.stream()
                 .forEach(System.out::println);

        System.out.println("Employees salary greater than 80000 and last name starts with A: ");
        //salary >80k and last name starts with A
        employees.stream()
                 .filter(salary->salary.getSalary()>25000)
                .filter(lastname->lastname.getLastName().startsWith("A"))
                 .forEach(System.out::println);

        System.out.println("Employees sorted by first name: ");
        //sort by first name
        employees.stream()
                 .sorted(Comparator
                         .comparing(employee->
                                 employee.getFirstName()
                                         .toLowerCase()))
                 .forEach(System.out::println);

        System.out.println("Various departments: ");
        //various departments
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        System.out.println("Count the number of employees in developer department: ");
        //count the employees in developer department
        Long count=employees.stream().filter(employee-> Objects.equals(employee.getDepartment(), "Java Developer")).count();
        System.out.println(count);

        //sum of all employees salaries
        Double sum=employees.stream().map(Employee::getSalary).reduce(0.0,Double::sum);
        System.out.println(sum);

        System.out.println("Employee salary in development department: ");
        //sum of employees salary in development department
        Double devSal=employees.stream().filter(employee -> Objects.equals(employee.getDepartment(), "Developer")).map(Employee::getSalary).reduce(0.0,Double::sum);
        System.out.println(devSal);

        System.out.println("Maximum salary of the employee: ");
        //max salary of the employee
        Optional<Double> maxSalary=employees.stream().map(Employee::getSalary).reduce(Double::max);
        System.out.println(maxSalary);

        System.out.println("List of firstnames of all employees: ");
        //list of firstname of all employees
        System.out.println(employees.stream().map(Employee::getFirstName).toList());

        System.out.println("Immutable list of names: ");
        //immutable list of names
        List<String> immutableList=employees.stream().map(Employee::getLastName).distinct().collect(Collectors.toUnmodifiableList());
        // immutableList.add("lucky"); if we add anything, it wont add because the list is unmodified type

        System.out.println(immutableList);
        //Map of employees data with name as key and salary as values
        Map<String, String> employeeMap=employees.stream()
                .collect(Collectors
                        .toMap(e->e.getFirstName(),
                                e->String.valueOf(e.getSalary()),
                                (a,b)-> a+" "+b));
        System.out.println(employeeMap);

        Map<String, Long> genderCount=employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(genderCount);
    }
}
