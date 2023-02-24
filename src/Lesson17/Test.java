/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson17;

/**
 *
 * @author vitaliy
 */
public class Test {

    public static void main(String[] args) {
        
        System.out.println(raventstvo(new StringBuilder(), new StringBuilder()));
               
        
    }
    
    public static boolean raventstvo(StringBuilder a, StringBuilder b) {
        String tempStr1 = a.substring(0);
        String tempStr2 = b.substring(0);
        
        return tempStr1.equals(tempStr2)? true: false;       
        
    }
    

}

