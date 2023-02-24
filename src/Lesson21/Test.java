package Lesson21;

import java.util.ArrayList;
import java.util.Collections;


public class Test {
    
    
    public static void main(String[] args) {
        abc("один", "два", "ок", "два", "апять", "7", "7", "s");
        
    }
    
    static void abc(String...param) {
        
        ArrayList <String> list = new ArrayList<>();
        
        for (String element: param) {
            if (list.indexOf(element)==-1) {
                list.add(element);    
            }
        }
        Collections.sort(list);
        System.out.println(list.toString());
    }
    
}
