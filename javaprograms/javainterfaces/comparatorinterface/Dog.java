package javainterfaces.comparatorinterface;

import java.util.Comparator;

class Dog implements Comparator<Dog>, Comparable<Dog>
{
    private String name;
    private int age;

    Dog() {
    }

    Dog(String n, int a) {
        name = n;
        age = a;
    }

    public String getDogName() {
        return name;
    }

    public int getDogAge() {
        return age;
    }

    @Override
    public int compareTo(Dog d) {
        return (this.name).compareTo(d.name);
    }

    @Override
    public int compare(Dog d, Dog d1) {
        return d.age - d1.age;
    }

    @Override
    public String toString() {
        return this.name + "," + this.age;
    }
}