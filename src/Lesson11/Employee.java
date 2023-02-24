package Lesson11;


public class Employee {
    public String name;
    public double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public double uvelichenie(double a){
        a = a *2;
        return a;
    }
    
    public double zp2(){
        salary = salary * 2;
        return salary;
    }
    
}

class EmployeeTest{
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ivan", 100.550);
        double d = emp1.uvelichenie(emp1.salary);
        emp1.zp2();
        System.out.println(emp1.salary);
    }
}
