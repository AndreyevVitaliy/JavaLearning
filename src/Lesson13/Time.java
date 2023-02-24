/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson13;

/**
 *
 * @author vitaliy
 */
public class Time {
    
    public static void main(String[] args) {
        getTime();
    }
    
    static void getTime(){
        HOUR: for (int i = 0; i <=6; i++){
            
            MINUTE: for (int j = 0; j < 60; j++){
                
                if ((j % 10 == 0) && (i > 1)) {
                    break HOUR;
                }
                
                SEKUND: for (int k = 0; k < 60; k++) {
                    if (k * i > j) {
                        continue SEKUND;
                    }
                    System.out.println(i + ":" + j + ":" + k);
                }
                
            }
            
            
        }
    }
    
}
