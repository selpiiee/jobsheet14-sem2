package Week14;

public class Student21 {
    String nim, name, className;
    Double gpa;

    public Student21(String nm, String name, String kls, double gpa) {
        this.nim = nm;
        this.name = name;
        this.className = kls;
        this.gpa = gpa;
    }

    public void print() {
        System.out.println(nim + " - " + name + " - " + className + " - " + gpa);
    }
}