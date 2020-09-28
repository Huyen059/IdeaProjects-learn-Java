class Employee {

    String name;
    int salary;
    String address;

    public Employee() {
        this.name = "unknown";
        this.salary = 0;
        this.address = "unknown";

    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.address = "unknown";
    }

    public Employee(String name, int salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }
}

class A {

    protected int n = 10;
    protected String s = "abc";
    protected char ch = 'q';

    public A(int n) {
        this.n = n;
    }
}

class B extends A {

    protected int n = 20;
    protected String s = "str";
    protected char ch = 'z';

    public B(int n, String s, char ch) {
        super(n);
        this.s = s;
        super.ch = ch;
    }

    public void print() {
        System.out.println(super.n + " " + super.s + " " + ch);
    }
}

public class Main {
    public static void main(String[] args) {
        B b = new B(100, "txt", 'k');
        b.print();
    }
}