/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson22;

/**
 *
 * @author vitaliy
 */
public class Test1 {
    public static void main(String[] args) {
        Student student = new Student();
        
        student.setName(new StringBuilder("Kolya"));
        student.setCourse(3);
        student.setGrade(10);
        
        student.getName().append("!!!");
        
        student.showinfo();
        
    }
}

class Student {

    /**
     * @return the name
     */
    public StringBuilder getName() {
        StringBuilder tempDB = new StringBuilder(name);
        return tempDB;
    }

    /**
     * @param name the name to set
     */
    public void setName(StringBuilder name) {
        //if (name.length() >= 3) {
            this.name = name;
            System.out.println(name);
        //}
    }

    /**
     * @return the course
     */
    public int getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(int course) {
        if (course >= 1 && course <= 4) {
            this.course = course;
            
        } else {
            System.out.println("Неверное указан курс");
        }
    }

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 10) {
            this.grade = grade;
        }else {
            System.out.println("Неверное указана оценка");
        }
    }
    
    void showinfo() {
        System.out.println("Имя:" + getName() + ", курс: " + getCourse() + ", оценка:" + getGrade());
    }
    
    private StringBuilder name;
    private int course;
    private int grade;
    
    

}
