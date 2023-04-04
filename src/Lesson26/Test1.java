package Lesson26;

import java.util.ArrayList;

public class Test1 {

    public static void main(String[] args) {
        Car c1 = new Car("red", "v4");
        Car c2 = new Car("black", "v8");
        Car c3 = new Car("red", "v4");
        Car c4 = new Car("red", "v4");

        System.out.println(c1.equals(c3));

        ArrayList <Car> listCar = new ArrayList<>();
        listCar.add(c1);
        listCar.add(c2);
        listCar.add(c3);

        System.out.println(listCar.contains(c4));


    }


}

class Car{
    String color = "";
    String engine = "";

    Car(String color, String engine){
        this.color = color;
        this.engine = engine;
    }


    public boolean equals(Car obj) { //корректный Override метода только с использованием параметров типа Object
        if (this instanceof Car) {
            Car tempCar = (Car) obj;
            return (this.color == tempCar.color) && (this.engine == tempCar.engine);
        } else {
            return false;
        }

    }
}

