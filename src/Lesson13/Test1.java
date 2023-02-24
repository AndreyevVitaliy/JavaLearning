/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson13;

/**
 *
 * @author vitaliy
 */
public class Test1 {

    public static void main(String[] args) {
        getTime();

    }

    static void getTime() {
        int i = 0;
        HOUR:
        while (i <= 6) {

            int j = 0;
            MINUTE:
            do {

                if ((j % 10 == 0) && (i > 1)) {
                    break HOUR;
                }

                int k = 0;
                SEKUND:
                while (k < 60) {
                    System.out.println(i + ":" + j + ":" + k++);
                }

            } while (j++ < 59);

            i++;
            
            String str = "Privet";
              
        }
    }

}
