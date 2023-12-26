//Purna Chhetri
//CSC-101 Project 3
//This program finds various values of a triangle 

import java.util.Scanner; //Scanner for input
class Triangle{ //Start of class
   public static void main(String[]args){ //Start of main
      //Objects
      Scanner keyboard = new Scanner(System.in);
      
      //Intro 
      System.out.println("Welcome to my triangle calculator");
      System.out.println("Please enter in the values for the two smaller sides of a right triangle");
      
      //Input
      double value_one = keyboard.nextDouble(); 
      double value_two = keyboard.nextDouble();
      
      //Results
      double area = areaTriangle(value_one,value_two);
      double hypotenuse = hypotenuseTriangle(value_one, value_two);
      double perimeter = trianglePerimeter(value_one,value_two);
      
      //Output
      System.out.printf("The area of the triangle is %.2f", area);
      System.out.println();
      System.out.printf("The value of the hypotenuse is %.2f", hypotenuse);
      System.out.println();
      System.out.printf("The perimeter of the triangle is %.2f", perimeter);
      
   } //End of main
   public static double areaTriangle(double value_one, double value_two){ //start of method
      //Calculations 
      double area = (value_one*value_two)/2;
      return area;   
   } //End of method
      
   public static double hypotenuseTriangle(double value_one, double value_two){ //start of method
      //Calculations 
      double hypotenuse = Math.sqrt(Math.pow(value_one,2)+Math.pow(value_two,2));   
      return hypotenuse;  
   } //End of method 
   
   public static double trianglePerimeter(double value_one, double value_two){ //start of method
      //Calculations 
      double perimeter = value_one + value_two + hypotenuseTriangle(value_one,value_two);
      return perimeter;  
       
   } //End of method 
} //End of class