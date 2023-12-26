//Purna Chhetri
//CSC-101 Lab 5 Part 2
//This program calculates pi to a given precision 

import java.util.*; //importing Scanner
class Summation{ //start of class
   public static void main(String[]args){ //start of main
      
      //Obejcts 
      Scanner keyboard = new Scanner(System.in);
      
      //Variables
      double i = 1;
      double j = 1;
      double sum = 0;
      double num = 0;
      int counter = 0;
      double loop_limit = 35000000;
      
      //Prompt for precision 
      System.out.println("How many decimal places");
      
      //Input on precision 
      int decimal_places = keyboard.nextInt();
      double power = Math.pow(10,decimal_places);
      int power_int = (int)power;
      
      //Calculating the precision for pi based on the given input
      double pie = Math.PI;
      double pie_round = Math.round(pie*power_int)/power; //credit to https://www.geeksforgeeks.org/how-to-set-precision-for-double-values-in-java/amp/
      
      
      //Loop
      for(i=1;i<=loop_limit;i+=2){ //start of loop
         double term = (4/i); //divides 4 by i, which will increase by 2 every loop
         counter++; //counter for counting how many loops
         num++; //adds one to num 
         if(num%2==0){ //checks if num is divisible by 2
            sum-=term; //if its divisible by 2, the sum is subtracted
         }else{ 
            sum+=term; //if its not divisible by 2, the sub is added 
         } //end of else
         double round = Math.round(sum*power_int)/power; //rounds the sum to the given decimal places
         System.out.println(round); 
         if(round==pie_round){ //compares the value to pie and if they're equal, the loop ends 
            i=loop_limit; 
            System.out.printf("It took %d loops to find pi to %d decimal places", counter, decimal_places);
         }//end of if
                       
      } //end of loop
   } //end of main
} //end of class   