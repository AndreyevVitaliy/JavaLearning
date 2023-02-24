/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson20;
import java.util.Arrays;

/**
 *
 * @author vitaliy
 */
public class Test {
    
    static String[] abc(String []...array) {
    
        int size = 0;
        for (String[] array2:array) {
            for (String element:array2) {
                size++;
            }
        }
    
        int el = 0;
        String newArray[] = new String[size];
        for (String[] array2:array) {
            for (String element:array2) {
                newArray[el] = element;
                el++;
            }
        }
        
        return newArray;
        
    }
    
    public static void main(String[] args) {
        
        String array [] = abc(new String[]{"Элемент1","Элемент2"}, new String[] {"Элемент3","Элемент4"}, new String []{"Элемент5","Элемент6"});
        Arrays.sort(array);
        
        System.out.println(Arrays.toString(array));
        
        
        
        String arrayFind[] = {"Элемент6", "Элемент2"};        
        
        for (String param: arrayFind) {
            for (int i = 0; i <= array.length-1; i++){
                if (param == array[i]) {
                    array[i] = null;
                }
            }
        }
        
        System.out.println(Arrays.toString(array));
    }
    
}
