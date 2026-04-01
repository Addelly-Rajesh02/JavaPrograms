package oops;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeData {

    public static ArrayList<Employee> get(){
        return new ArrayList<Employee>(Arrays.asList(
                new Employee(1,"rajesh","Addelly","Developer",24,"Male",38000.0),
                new Employee(2,"rajesh","Bara","Tester",30,"Male",13000.0),
                new Employee(3,"Akash","Yemmey","Devops Engineer",25,"Male",90000.0),
                new Employee(4,"Tanooj","Akula","Data Engineer",28,"Male",100000.0),
                new Employee(5,"Priya","Myathari","Developer",24,"Female",38000.0),
                new Employee(8,"Deepika","Goda","Java Developer",30,"Female",13000.0),
                new Employee(7,"Sneha","Cilivery","Human Resource",25,"Female",90000.0),
                new Employee(6,"jyothi","Boini","Analyst",28,"Female",100000.0)
                ));
    }
}
