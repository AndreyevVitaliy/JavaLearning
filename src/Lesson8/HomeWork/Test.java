package Lesson8.HomeWork;


public class Test {
    
    static final double pi = 3.14;
    
    static int multiplizieren(int a, int b, int c) {
        
        int d = a * b * c;        
                
                
        return d;
    }
    
    static void unterteilen(int a, int b) {
        System.out.println("Частное " + a / b);
        System.out.println("Остаток " + a % b);
    }
  
    double s(int rad) {
        return pi * rad * rad;
    }
    
    static double dlina(int rad) {
        return 2 * pi * rad;
    }
    
    void output(int rad) {
        System.out.println("Радиус: " + rad);
        System.out.println("Площадь круга: " + s(rad));
        System.out.println("Длина окружности: " + dlina(rad));
    }
    
    
    
    
}

class Test2 {
    public static void main(String[] args) {
        System.out.println("Произведение 1: " + Test.multiplizieren(2,2, 2));
        System.out.println("Произведение 2: "+ Test.multiplizieren(1, 1, 2));
        
        Test.unterteilen(20, 3);
        Test.unterteilen(21, 3);
        
        
        System.out.println(Test.dlina(12));
                
               
        Test obj = new Test();
        
        System.out.println(obj.s(12));
        
        System.out.println();
        obj.output(12);
        
        
      
 
        
    }
}
