package Lesson6;


public class HomeWork {
    public static void main(String[] args) {
        Student studen1 = new Student(1, "Max", "John", 2022, 4, 5, 3);
        Student studen2 = new Student(2, "Petr");
        Student studen3 = new Student();
        
        studen1.info();
        studen2.info();
        studen3.info();
        
        Sum sum1 = new Sum();
        sum1.sum();
        sum1.sum(1);
        sum1.sum(1,1);
        sum1.sum(1,1,1);
        sum1.sum(1,1,1,1);
        sum1.sum(1,1,1,1, 1);
        
    }
}


class Sum {
    void sum(int a, int b, int c, int d, int e) {
        output(a, b, c, d, e);
    }
    
    void sum(int a, int b, int c, int d) {
        output(a, b, c, d, 0);
    }
    
    void sum(int a, int b, int c) {
        output(a, b, c, 0, 0);
    }
    
    void sum(int a, int b) {
        output(a, b, 0, 0, 0);
    }
    
    void sum(int a) {
        output(a, 0, 0, 0, 0);
    }
    
    void sum() {
        output(0, 0, 0, 0, 0);
    }
    
    
    void output(int a, int b, int c, int d, int e) {
        System.out.println(a + b + c + d + e); 
    }
    
}

class Student {
    
    int numberTicket = 0;
    String name = "";
    String Surname = "";
    int learningYear = 0;
    double avMath = 0;
    double avEkonomic = 0;
    double avLang = 0;
    
    Student (int numberTicket, String name, String surName, int learningYear, int avMath, int avEkonomic, int avLang) {
        this.numberTicket = numberTicket;
        this.name = name;
        this.Surname = surName;
        this.learningYear = learningYear;
        this.avMath = avMath;
        this.avEkonomic = avEkonomic;
        this.avLang = avLang;
    }
    
    Student (int numberTicket, String name) {
        this(numberTicket, name, null, 0,0,0,0 );
    }
    
    Student () {
        
    }
    
    
    double summa() {
        return avMath + avEkonomic + avLang;
    }
    
    double averrage() {
        return summa()/3;
    }
    
    String getName(){
        return Surname + " " + name;
    }
    
    void info() {
        System.out.println( this.numberTicket + " " +
                            this.name + " " +
                            this.Surname + " " +
                            this.learningYear + " " +
                            this.avEkonomic + " " +
                            this.avLang + " " +
                            this.avMath);
    }
    
}
