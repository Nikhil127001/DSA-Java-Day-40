package mypackage;
import javax.sound.sampled.SourceDataLine;
public class OOPs {
    public static void main(String args[]) {
//         Pen p1 = new Pen(); // created a pen object called p1 and allocate memory for it
//         p1.setColor("blue");
//         System.out.println(p1.Color);
        

//         // here we cannot acces Password attribute from the class cuz it is private
//         Bank b1 = new Bank();
//         b1.setPassword("kdnfjknsjdf");
       
//         Students s1 = new Students();
//         s1.setName("tony");
//         s1.getName();
//         s1.setGrade("eleventh");
//         s1.getGrade();


//         Desserts d0 = new Desserts();
        
//         Desserts d1 = new Desserts("rasgulla", "white");
//         System.out.println(d1.name);
//         System.out.println(d1.color);
//         d1.Marks[0] = 99;
//         d1.Marks[1] = 100;
//         d1.Marks[2] = 101; 

//         Desserts d2 = new Desserts(d1);
//         d2.Password  = "jalebi";
//         System.out.println(d2.Password);
//         d1.Marks[1]= 99;
//         for (int i = 0; i < d2.Marks.length; i++) {
//             System.out.println(d2.Marks[i]);
//         }

        //    Animals a1 = new Animals();
        //    System.out.println(a1.sleep);
        //     System.out.println(a1.Eat);
        //     System.out.println(a1.run);

        //    Harvivoras b1 = new Harvivoras();
        //    System.out.println(b1.sleep);
        //     System.out.println(b1.Eat);
        //     System.out.println(b1.run);

        //    Omnivoras c1 = new Omnivoras();
        //    System.out.println(c1.sleep);
        //     System.out.println(c1.Eat);
        //     System.out.println(c1.run);

        //     Calculator e1 = new Calculator();
        //     System.out.println(e1.sum( 2, 3));
        //     System.out.println(e1.sum( 2, 3,4));
        //     System.out.println(e1.sum( 2, 3,4,5));

        //     Lion l1 = new Lion();
        //     l1.eat();


        // // we cannot create object of abstract class
        // // Animal j1 = new Animal();
        // Horse h1 = new Horse();
        // h1.breath();
        // h1.eat();
    }
}

// // Abstraction 
// abstract class Animal{
//     // you cannot creat object of this Animal class but you can create its constructor
//     Animal(){
//         System.out.println("Animal  constructor called");
//     }
//    void  breath(){
//     System.out.println("Animals breaths");
// };
//    // if you define abstract function here then it is compulsory to use it in inherited sub classes
//     abstract void eat();
// }
// class Horse extends Animal{
//     Horse(){
//           System.out.println("Horse Constructor called");  
//     }
//     void eat(){
//         System.out.println("horse eats grass");
//     }
// }
// class Mustang extends Horse{
//     Mustang(){
//         System.out.println("Mustang constructor Called...");
//     }
// }

// // polymorphism
// // method overriding
// class Creatures{
//     void eat(){
//         System.out.println("food");
//     }
// }

// class Lion extends Creatures{
//     void eat(){
//         System.out.println("non veg");
//     }
// }
// // method overloading
// class Calculator{
//     int  sum(int a, int b){
//         return a+b;
//     }
//     int  sum(int a, int b, int c){
//         return a+b+c;
//     }
//     int  sum(int a, int b, int c, int d){
//         return a+b+c+d;
//     }
// }

// Inheritence In java
// types
//multilevel inheritence --  in which subclasses of a class has its own subclass

// // Hierarchical inheritance 
// class Animals{
//     String Eat = "food";
//     String sleep = "sleeping";
//     String run = "running";
// }
//  class Omnivoras extends Animals{
//     String Eat = "eat both non veg and veg";
//  }

//  class Harvivoras extends Animals{
//     String Eat = "Eat veg only";
//  }
//  class Carnivoras extends Animals{
//     String Eat = "Eats non veg only";
//  }

// //constructor in java
// class Desserts{
//     String name = "ladoo";
//     String color = "yellow";
//     String Password;
//     int Marks[];
     
//     // non peremeterized constructor
//     Desserts(){
//         Marks = new int[3];
//         System.out.println(
//             "Hiii i am non parameterised Constructor"
//         );
//     }

//      // non peremeterized constructor
//     Desserts(String name, String color){
//         Marks = new int[3];
//         System.out.println(
//             "Hiii i am parameterised Constructor"
//         );
//        this.name = name;
//        this.color= color;
//     };



    ////shallow copy constructor
    // Desserts(Desserts d1){
    //  Marks = new int[3];
    //  System.out.println("hii i am copy constructor");
    //  this.name = d1.name;
    //  this .color = d1.color;
    //  this.Marks = d1.Marks;
     
    //  System.out.println(d1.name);
    //  System.out.println(d1.color);
    // };
    // deep copy constructor
    // Desserts(Desserts d1){
    //  Marks = new int[3];
    //  System.out.println("hii i am deep copy constructor");
    //  this.name = d1.name;
    //  this .color = d1.color;
    //  for (int i = 0; i < Marks.length; i++) {
    //     this.Marks[i] = d1.Marks[i];
    //  }     
    //  System.out.println(d1.name);
    //  System.out.println(d1.color);


//     };
// }




// //getters and Setters
// class Students{
//     private String name = "Rahul";
//     private String grade = "tenth";

//     public void setName(String  name){
//         this.name = name;
//     }
//     public void getName(){
//         System.out.println(name);
//         //or return name;
//     }
//     public void setGrade(String  grade){
//         this.grade = grade;
//         System.out.println(this.grade);
//     }
//     public void getGrade(){
//         System.out.println(grade);
//         //or return grade;
//     }

// }



// class Bank {
//     public String name = "Mohan";
//     private String Password = "123@123";

//     void setPassword(String pwd) {
//         Password = pwd;
//     }

// }

// class Pen {
//     String Color = "red";
//     int tip = 5;

//     void setColor(String color) {
//         Color = color;
//     }

//     void setTip(int Tip) {
//         tip = Tip;
//     }
// }
