
package Lesson13;

import java.time.*;
/**
 *
 * @author vitaliy
 */
public class Month {
    
    public static void main(String[] args) {
        countDays(1);
    }

    static void countDays(int count) {
        LocalDate date = LocalDate.now();
        
        System.out.println(date.getMonth());
        switch (count) {
            case  1:
            case  2:
                case  3:
                    System.out.println("3");
               
                default:
                System.out.println("1");
                break;
                
                
                
         
                
            
        }
    }
    
}

