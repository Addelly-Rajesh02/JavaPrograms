package oops;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String department;
    private Integer age;
    private String gender;
    private Double salary;

    public Employee() {
    }

    public Employee(Integer id, String firstName, String lastName, String department, Integer age, String gender, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
