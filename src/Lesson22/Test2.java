/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson22;

/**
 *
 * @author vitaliy
 */
public class Test2 {

    public static void main(String[] args) {
        Dog dog1 = new Dog("Sharik");
        System.out.println(dog1.paw);

        Cat cat1 = new Cat("Musya");
        cat1.sleep();

    }

}

class Animal {

    Animal() {
        System.out.println("I am animal");
    }

    int eyes;

    void eat() {
        System.out.println("Animal eats");
    }

    void drink() {
        System.out.println("Animal drinks");
    }

}

class Pet extends Animal {

    Pet() {
        System.out.println("I am Pet");
        eyes = 2;
    }

    String name;
    int teil = 1;
    int paw = 4;

    void run() {
        System.out.println("Pets runs");
    }

    void jump() {
        System.out.println("Pet jumps");
    }

}

class Dog extends Pet {

    Dog(String name) {
        this.name = name;
        System.out.println("I am Dog and my name is: " + name);
    }

    void play() {
        System.out.println("Dogs plays");
    }

}

class Cat extends Pet {

    Cat(String name) {
        this.name = name;
        System.out.println("I am Cat and my name is: " + name);
    }

    void sleep() {
        System.out.println("Cat sleeps");
    }
}
