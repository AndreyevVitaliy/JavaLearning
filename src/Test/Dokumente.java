/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

/**
 *
 * @author vitaliy
 */
public class Dokumente {
    
    final Spr klient = new Spr();
    final Table table = new Table();
    final Tovar tov = new Tovar();
    
    Dokumente(){
        
    }
    
    public static void main(String[] args) {
        Dokumente doc = new Dokumente();
        doc.klient.nummer = 1;
        doc.klient.name = "Новый";
        doc.tov.artikul = 100;
        doc.tov.copy();
    }
    
}


class Tovar extends Spr {
    int artikul;
}

class Spr {
    int nummer;
    String name;
    
    protected void copy() {
        
    }
    
}

class Table {
    
}