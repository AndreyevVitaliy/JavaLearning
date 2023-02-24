package Lesson4;

public class StudentTest {
    public static void main(String[] args) {
        
//        Students student1 = new Students();
//        Students student2 = new Students();
//        Students student3 = new Students();
//        
//        student1.numberTicket = 1;
//        student1.name = "Max";
//        student1.Surname = "Fix";
//        student1.learningYear = 2022;
//        student1.mittelNoutMath = 3;
//        student1.mittelNoutEkonomic = 5;
//        student1.mittelNoutLanguage = 3;
//        
//        student2.numberTicket = 2;
//        student2.name = "John";
//        student2.Surname = "Mike";
//        student2.learningYear = 2022;
//        student2.mittelNoutMath = 5;
//        student2.mittelNoutEkonomic = 4;
//        student2.mittelNoutLanguage = 4;
//        
//        student3.numberTicket = 3;
//        student3.name = "Maximilian";
//        student3.Surname = "Fox";
//        student3.learningYear = 2022;
//        student3.mittelNoutMath = 5;
//        student3.mittelNoutEkonomic = 5;
//        student3.mittelNoutLanguage = 4;
   
//        System.out.println("Среднее значение для студента " + student1.getName() + ": " + student1.averrage());
//        System.out.println(student2.averrage());
//        System.out.println(student3.averrage());
    
//        Employees human = new Employees(1,"MAX", 34, 1223, 2000);
//        human.doubleSum();
        //human.info();
        
//        System.out.println(human.bankAccount.account);
//        human.bankAccount.eingeben(120);
//        human.bankAccount.abheben(100);
//        System.out.println(human.bankAccount.account);
//     
        //human.info();
        
        
        
        
    }
      
}

class Students {
    
    int numberTicket = 0;
    String name = "";
    String Surname = "";
    int learningYear = 0;
    double mittelNoutMath = 0;
    double mittelNoutEkonomic = 0;
    double mittelNoutLanguage = 0;
    
    double summa() {
        return mittelNoutMath + mittelNoutEkonomic + mittelNoutLanguage;
    }
    
    double averrage() {
        return summa()/3;
    }
    
    String getName(){
        return Surname + " " + name;
    }
   
}




class newTest {
    public static void main(String[] args) {
        
        Employees employee1= new Employees(2, "Bonder", 15, 2000, 2500);
        employee1.getSalary();
        employee1.getID();
        employee1.getSurname();
        
    }
    
    
    
    
    
}

