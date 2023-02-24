package Lesson4;

public class Employees {
    
    int id;
    public String surname;
    int age;
    private double salary;
    Departments department;
    BankAccount bankAccount;

    public Employees(int id, String surname, int age, double salary, int bankAccount) {
        this.id = id;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.department = new Departments();
        //System.out.println("Счет: " + bankAccount);
        this.bankAccount = new BankAccount(bankAccount);
  
    }
    
    private Employees(int id, String surname, int age, double salary) {
        this(id, surname, age, salary, 0);
    }
    
    Employees(int id) {
        this(id, null, 0, 0.0, 0);
    }
          
    public void doubleSum() {
        salary *=2;
    }
    
    void info() {
        System.out.println(this.bankAccount.account);
    }
    
    public void getSalary(){
        System.out.println("Зарплата: " + salary);
    }

    public void getID(){
        System.out.println("ID: " + id);
    }
    
    public void getSurname(){
        System.out.println("Фамилия: " + surname);
    }

    
}


class BankAccount {
    
    int id;
    int account;
    
    
    public BankAccount() {
        this.account = 0;
    }
    
    public BankAccount(int account) {
       this.account = account;
    }
    
    void eingeben(int summa) {
        this.account+=summa;
    }
    
    void abheben(int summa) {
        this.account-=summa;
    }
    
    
    
}

class Departments {
    int id;
    String name;
}
