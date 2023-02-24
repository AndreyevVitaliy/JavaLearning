package Lesson17;

import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class NewClass {

    public static void main(String[] args) {

        int array[] = {9, 1, 2, 4, 6, 8, 9, 7, 54, 3};

        String array2[][] = {   {"элемент1", "элемент12"},
                                {"элемент3", "элемент4"},
                                {"Привет", "Пока", "Элемент"},
                                {"Новый", "Элемент", "Массива", "из","6","значений"}};

        //System.out.println(array2[2][7]);
        showArray(array2);
        
        

        //System.out.println(Arrays.toString(sortirivka(array)));
    }

    public static int[] sortirivka(int[] array) {
        int i = 0;

        while (true) {

            if (i >= array.length - 1) {
                break;
            }

            if (array[i] > array[i + 1]) {
                int temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
                i = 0;
                continue;
            }

            i++;
        }

        return array;

    }

    public static void showArray(String array[][]) {

        String result = "{";

        for (int i = 0; i < array.length; i++) {

            result = result + "{";

            for (int j = 0; j < array[i].length; j++) {

                result = result + array[i][j];
                if (j < array[i].length - 1) {
                    result = result + ", ";
                }

            }
            result = result + "}";
            if (i < array.length - 1) {
                result = result + ", ";
            }

        }
        result = result + "}";
        System.out.println(result);

    }

}
