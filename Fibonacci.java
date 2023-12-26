//Purna Chhetri
//CSC-101 Lab 5 Part 3
//This program outputs a given amount of Fibonacci numbers

import java.util.Scanner; //Importing scanner for input
class Fibonacci{ //start of class
   public static void main(String[]args){ //start of main
      
      //Creating Scanner object
      Scanner keyboard = new Scanner(System.in);
      
      //Prompt for input
      System.out.println("Please enter how many outputs you want");
      
      //Variables 
      int num = 1;
      int sum = 1;
      int sum2 = 1;
      int sum3 = 1;
      int sum4 = 1;
      int counter = 0;
      boolean check = true;
      //Input on how many numbers to output
      int output = keyboard.nextInt();
      int output_amount = output+1; 
      
      //Loop  
      for(int i=1;i<=output_amount;i++){ //start of for loop
         if(num==1){ // the first one
            counter++;
            if(counter<output_amount){ //output will only be printed if the counter is less than the requested output amount
               System.out.println(num); 
            }//end of nested if
         } //end of if
         sum = num; //assigning the second value to a variable
         counter++; //adding one to counter
         i++; //adding one to the for loop
         if(counter<output_amount){ //output will only be printed if the counter is less than the requested output amount
            System.out.println(sum);
         }
         sum2 = num+sum4; //adds the previous two values
         i++;
         counter++;
         if(counter<output_amount){
            System.out.println(sum2);
         }
         sum3 = sum2+sum; //adds the previous two values
         i++;
         counter++;
         if(counter<output_amount){
            System.out.println(sum3);
         }
         sum4= sum3+sum2; 
         i++;
         counter++;
         if(counter<output_amount){
            System.out.println(sum4);
         }
         num = sum4+sum3; //assigns the number to it can shift to the next loop      
      }//end of for loop
      System.out.println("Thanks for using my program! Goodbye!");
   } //end of main
} //end of class