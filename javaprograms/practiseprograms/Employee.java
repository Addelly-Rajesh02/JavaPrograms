package practiseprograms;

// Domain model: Comparable defines NATURAL order (here: by id)
class Employee implements Comparable<Employee> {
    private final Integer id;      // natural order will be based on id
    private final String name;
    private final Integer age;
    private final Double salary;   // nullable to show null-safe comparator
    private final String gender;
    private final String department;


    public Employee(Integer id, String name, Integer age, Double salary, String gender, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary; // can be null
        this.gender=gender;
        this.department=department;

    }

    public Integer getId()     { return id; }
    public String getName()    { return name; }
    public Integer getAge()    { return age; }
    public Double getSalary()  { return salary; }
    public String getGender()  { return gender; }
    public String getDepartment(){ return department; }

    // Comparable: NATURAL ORDERING (id ascending)
    @Override
    public int compareTo(Employee other) {
        /*
        We can use two methods for sorting the data
        return Integer.compare(this.id, other.id);
        */
        return this.id - other.id;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', age=%d, gender='%s', department='%s' salary=%s}",
                id, name, age, gender, department, salary == null ? "null" : String.format("%.2f", salary));
    }
}