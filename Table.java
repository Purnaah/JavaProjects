//Purna Chhetri 
//CSC-101 Lab 5 Part 1
//This program creates a table based on the price

import java.util.Scanner; //Scanner for input
class Table{ //start of class
   public static void main(String[]args){ //start of main
      
      //Objects
      Scanner keyboard = new Scanner(System.in);
      
      //Variables and constants
      int length = 1; 
      int width = 1;
      int header = 1;
      String width_text = "WIDTH(feet)";
      
      //Input on price
      System.out.println("Welcome to my flooring cost table");
      System.out.println("Please enter the cost per square foot");
      final double PRICE_PER_SQUARE = keyboard.nextDouble();
      
      //Header
      System.out.printf("%50s",width_text);
      System.out.println();
      
      //For loop
      for(header=1;header<=12;header++){
         System.out.printf("%9d",header);
      }
      System.out.println();
         for(width = 1; width<=8; width++){
            System.out.print(width+"");
            for(length = 1; length<=12; length++){
               double total_price = length*width*PRICE_PER_SQUARE;
               System.out.printf("  $%5.2f ",total_price);
            }
            System.out.println();
         }
     System.out.println("Here's the table, goodbye!");    
      
   } //end of main
} //end of class   