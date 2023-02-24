/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lesson16;

/**
 *
 * @author vitaliy
 */
public class HomeWork {

    public static void main(String[] args) {
        eMail("ya@yahoo.com; on@mail.ru; ona@gmail.com");
    }

    static void eMail(String str) {

        boolean flag = true;
        int positionAt = 0;
        int positionDot = 0;

        while (flag) {
            positionAt = str.indexOf("@");
            positionDot = str.indexOf(".");

            if (positionAt == -1 || positionAt == -1) {
                flag = false;
                break;
            }

            String nameServer = str.substring(positionAt + 1, positionDot);
            System.out.println(nameServer);
            str = str.substring(positionDot + 1);
            //System.out.println(str);

        }

    }

}
