/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson8;

/**
 *
 * @author vitaliy
 */
public class Student {
    String name;
    int course;
    int count;
    
    public Student(String name2, int course2) {
        count++;
        name = name2;
        course = course2;
        System.out.println(count);
    }
    
}

class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 1);
        Student student2 = new Student("Petr", 3);
        Student student3 = new Student("Masha", 2);
    }
}
