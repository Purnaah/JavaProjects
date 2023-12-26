//Purna Chhetri
//CSC-101 Lab 9  
//This program finds the average and standard deviation of a group of numbers

import java.util.Scanner; //Scanner for input
class StandardDev{ //Start of class
   public static void main(String[]args){ //Start of main
      //Objects and variables
      Scanner keyboard = new Scanner(System.in);
      double sum = 0;
      double total = 0;
      
      //Intro and input
      System.out.println("Welcome to my program");
      System.out.println("Please type in how many numbers you're entering:");
      int num = keyboard.nextInt();
      
      //Creating array based on the number entered
      double array[];
      array = new double[num];
      
      //A loop that assigns the numbers entered into the array
      for(int i = 0;i<num;i++){
         System.out.print("Enter in a number: ");
         array[i] = keyboard.nextDouble();
      }
      
      //A loop that adds the numbers to a counter variable
      for(double value: array){
         sum+=value;
      } 
      
      double average = sum/num; //finding the average of the numbers
      System.out.printf("The average of the numbers entered: %.2f",average); //outputting the average
      System.out.println();
      
      //Loop for the formula
      for(int j = 0; j<num;j++){ 
         total+=Math.pow((array[j]-average),2);
      }
      
      //Rest of the formula and the output
      double standard_dev = Math.sqrt((total/num));
      System.out.printf("The standard deviation of the given data is %.2f", standard_dev);
      System.out.println();
      
      //Goodbye
      System.out.println("Goodbye!");
      
   } //End of main
} //End of class