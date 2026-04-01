package inbuiltFunctions.langpackage;

import java.util.Objects;

/**
 * Demonstrates overriding and using core Object methods:
 * - toString()
 * - equals(Object)
 * - hashCode()
 * - clone()
 * - getClass()
 */
public class ObjectFunctions {

    // A simple domain class to demonstrate correct overrides
    static class Person implements Cloneable {
        private final int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // 1) toString(): human-readable representation
        @Override
        public String toString() {
            return "Person{id=" + id + ", name='" + name + "'}";
        }

        // 2) equals(): logical equality based on significant fields
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;                                 // same reference
            if (o == null || getClass() != o.getClass()) return false;  // must be same runtime class
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name);
        }

        // 3) hashCode(): must be consistent with equals()
        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        // 4) clone(): shallow copy via super.clone(); requires Cloneable
        @Override
        protected Person clone() {
            try {
                return (Person) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError("Clone not supported", e);
            }
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person(101, "Raj");
        Person p2 = new Person(101, "Raj");
        Person p3 = new Person(102, "Asha");

        // 5) getClass(): runtime class info
        System.out.println("getClass(): " + p1.getClass().getName());

        // toString()
        System.out.println("toString(): " + p1);

        // equals()
        System.out.println("equals(p1, p2): " + p1.equals(p2)); // true (same data)
        System.out.println("equals(p1, p3): " + p1.equals(p3)); // false

        // hashCode()
        System.out.println("hashCode(p1): " + p1.hashCode());
        System.out.println("hashCode(p2): " + p2.hashCode() + " (should match p1 if equals is true)");

        // clone()
        Person p1Clone = p1.clone();
        System.out.println("clone equals original: " + p1Clone.equals(p1)); // true
        p1Clone.setName("Raj Clone");
        System.out.println("After changing clone name:");
        System.out.println("original: " + p1);
        System.out.println("clone   : " + p1Clone);
    }
}