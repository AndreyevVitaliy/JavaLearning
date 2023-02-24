/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson12;




public class StudentTest {

    
    public static void sravnit(Student st1, Student st2){
        if ((st1.name.equals(st2.name) && (st1.course == st2.course) && (st1.facultet == st2.facultet) && (st1.surname.equals(st2.surname)))) {
            System.out.println("Студенты равны!");
        } else {
            System.out.println("Студенты не равны!");
        }
    }
    
    
    public static void sravnit2(Student st1, Student st2) {
        if ((st1.name.equals(st2.name))) {
            if (st1.course == st2.course) {
                if (st1.facultet == st2.facultet) {
                    if (st1.surname.equals(st2.surname)) {
                        System.out.println("У студента имя, фамилия, курс и факультет одинаковые");
                    } else {
                        System.out.println("У студента имя, курс и факультет одинаковые, а фамилии разные");
                    }                    
                } else {
                    System.out.println("У студента имя и курс одинаковые, а факультет отличается");
                }
                     
                
            } else {
                System.out.println("У студента имена одинаковые, а курсы разные");
            }            
        } else {
            System.out.println("У студента имена разные");
        }
            
        
        
    }
    
    
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", "Petrov", 2, "Economic");
        Student st2 = new Student("Ivan", "Petrov", 1, "Economic");
        sravnit(st1, st2);
        sravnit2(st1, st2);
        
    }
    
}

class Student {
    String name;
    String surname;
    int course;
    String facultet;
    
    Student(String name, String surname, int course, String facultet) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.facultet = facultet;
    }
    
    
    
}
