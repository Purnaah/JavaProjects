//Purna Chhetri
//CSC-101 
//This program takes in the expenses for the days of the week and reports it

import java.util.Scanner; //Scanner for input
class Expenses{ //Start of class
   public static void main(String[]args){ //Start of main
      
      //Objects and variables
      Scanner keyboard = new Scanner(System.in);
      double sum = 0;
      double total = 0;
      int check = 0;
      
      //Intro
      System.out.println("Welcome to my program");
      
      //Arrays
      double expenses[][] = new double[5][20];
      String days[] = {"Monday:", "Tuesday:", "Wednsday:", "Thursday:", "Friday:"};
      
      //Loops
      for(int i = 0;i<expenses.length;i++){ //The outer loop which represents the days 
         check = 0; 
         for(int j = 0;j<expenses[i].length;j++){ //Inner loop for the amount of expenses
            while (check!=-1){ //runs until the user wants to stop
               System.out.println("Please enter the expenses for "+days[i]);
               expenses[i][j] = keyboard.nextDouble();
               System.out.println("Type 1 to add more values, -1 to stop");
               check = keyboard.nextInt();
               j++; 
            }
            j = 20; //ending the loop 
         }
      }
      //Counter array
      int counter[] = new int[5];
      for(int i = 0; i<expenses.length;i++){
         for(int j = 0;j<expenses[i].length;j++){
            if(expenses[i][j]!=0){ //counting how many values the user entered 
               counter[i]+=1;
            }
         }
      }
      //Second array
      double array_actual[][] = new double [5][];
      
      for(int i = 0; i<array_actual.length;i++){ //Inputting the actual size of the array 
         array_actual[i] = new double[counter[i]];
      }
      
      for(int i = 0; i<array_actual.length;i++){ //Transferring the values from first array
         for(int j = 0;j<array_actual[i].length;j++){
            array_actual[i][j] = expenses[i][j];   
         }
      }
      
      //Output
      System.out.println("Weekly Expenses:");
      for(int i = 0; i<array_actual.length;i++){
         System.out.print(days[i]);   
         for(int j = 0;j<array_actual[i].length;j++){
            System.out.printf("%.0f ",array_actual[i][j]);
         }
         System.out.println();
      }
      
      for(int i = 0; i<array_actual.length;i++){ //finding the total 
         for(int j = 0;j<array_actual[i].length;j++){
            total += array_actual[i][j];  
         }
      }
      System.out.printf("Total: %.0f",total);
     
   } //End of main
} //End of class