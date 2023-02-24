/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson8;

/**
 *
 * @author vitaliy
 */
public class Car {
    String color = "blue";
    String engine = "V6";
}

class Human {
    String name = "Ivan";
    final Car c = new Car();
    
    public static void main(String[] args) {
        Human h1 = new Human();
        h1.c.engine = "v8";
    }
        
            
}