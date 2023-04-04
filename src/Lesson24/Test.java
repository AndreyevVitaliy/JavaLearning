package Lesson24;

public class Test {

    public static void main(String[] args) {
        Mechenosec mechenosec = new Mechenosec("Меченосец");
        System.out.println(mechenosec.name);
        mechenosec.eat();
        mechenosec.swim();
        mechenosec.sleep();

        System.out.println();
        Speakable pingvin = new Pingvin("Пингвин");
        pingvin.speak();

        System.out.println();
        Animal lev = new Lev("Лев");
        System.out.println(lev.name);
        lev.eat();
        lev.sleep();

        System.out.println();
        Mammal lev2 = new Lev("Второй лев");
        System.out.println(lev2.name);
        lev2.eat();
        lev2.speak();
        lev2.run();
        lev2.sleep();

    }

}

abstract class Animal{
    String name;
    Animal(String name){
        this.name = name;
    }

    abstract void eat();

    abstract void sleep();

}

abstract class Fish extends Animal{

    Fish(String name) {
        super(name);
        this.name = name;
    }

    void sleep(){
        System.out.println("Всегда интересно наблюдать, как спят рыбы");
    }

    abstract void swim();
}

abstract class Bird extends Animal implements Speakable{
    Bird(String name){
        super(name);
        this.name = name;
    }

    abstract void fly();

    @Override
    public void speak(){
        System.out.println(name + " sings");
    }

}

abstract class Mammal extends Animal implements Speakable{
    Mammal(String name){
        super(name);
        this.name = name;
    }

    abstract void run();

}

interface Speakable{
    default void speak(){
        System.out.println("Стандартный метод");
    }
}

 class Mechenosec extends Fish{
    Mechenosec(String name){
        super(name);
        this.name = name;
    }

     @Override
     void swim() {
         System.out.println("Меченосей красивая рыба, которая быстро плавает!");
     }

     @Override
     void eat() {
         System.out.println("Меченосей не хищная рыба и она есть обычный рыбий корм!");
     }
 }

 class Pingvin extends Bird{
    Pingvin(String name){
        super(name);
        this.name = name;
    }

     @Override
     void eat() {
         System.out.println("Пингвин любит есть рыбу");
     }

     @Override
     void fly() {
         System.out.println("Пингвины не умеют летать");
     }

     @Override
     public void speak() {
         System.out.println("Пингвины не умеют петь как соловьи");
     }

     @Override
     void sleep() {
         System.out.println("Пингвины спят пришавшись друг у другу");
     }
 }

 class Lev extends Mammal{
    Lev(String name){
        super(name);
        this.name = name;
    }

     @Override
     void eat() {
         System.out.println("Лев как любой хищник есть мясо");
     }

     @Override
     void sleep() {
         System.out.println("Большую часть дня лев спит");
     }

     @Override
     void run() {
         System.out.println("Лев это не самая быстрая кошка");
     }


 }


