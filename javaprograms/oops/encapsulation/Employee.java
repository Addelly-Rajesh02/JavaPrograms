package oops.encapsulation;

class Employee
{
    private int id;     // Private fields (encapsulated data)
    private String name;// Private fields (encapsulated data)

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}