/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson6;

/**
 *
 * @author vitaliy
 */
public class MethonOverloading {
    
    void show(int i) {
        System.out.println(i);
    }
    
    void show(boolean b) {
        System.out.println(b);
    }
    
    
    
}

class MethonOverloadingTest {
    public static void main(String[] args) {
        MethonOverloading mO = new MethonOverloading();
        int a = 500;
        mO.show(a);
        boolean b = true;
        mO.show (b);
    }
            
       
}
