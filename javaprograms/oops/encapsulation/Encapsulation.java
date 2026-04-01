package oops.encapsulation;

public class Encapsulation
{
    public static void main(String[] args)
    {
        Employee emp = new Employee();

        emp.setId(101);         // Using setters
        emp.setName("Geek");    // Using setters

        System.out.println("Employee ID: " + emp.getId());      // Using getters
        System.out.println("Employee Name: " + emp.getName());  // Using getters
    }
}