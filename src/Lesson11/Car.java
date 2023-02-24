package Lesson11;


public class Car {
    String color;
    String motor;
    int countDoor;
    
    Car(String color, String motor, int countDoor) {
        this.color = color;
        this.motor = motor;
        this.countDoor = countDoor;
    }
    
    
}

class CarTest {
    
    public static void changeDoorCount(Car car, int new_countDoor){
        car.countDoor = new_countDoor;
    }
    
    public static void swap(Car car1, Car car2) {
        String tempColor = "";
        tempColor = car1.color;
        car1.color = car2.color;
        car2.color = tempColor;
    }
    
    public static void main(String[] args) {
        Car car1 = new Car("white", "V6", 4);
        Car car2 = new Car("black", "V8", 2);
        
        swap(car1, car2);
        
        System.out.println(car1.color);
        System.out.println(car2.color);
        
        changeDoorCount(car1, 2);
        System.out.println(car1.countDoor);
        
        
    }
    
}