//Purna Chhetri
//CSC-101 Lab 11
//This program takes in numbers from user and finds the average, while handling exceptions that can occur 

import java.util.*; //For exceptions and scanner 

class PositiveExceptions{ //start of class
   public static void main(String[] args){ //start of main
      //Objects and variables and arrays
      Scanner keyboard = new Scanner(System.in);
      int[] numArray = new int[5];
      int number = 0;
      int total = 0;
      //Loop
      for(int i = 0; i<numArray.length;i++){ //Loop for 5 number
         try{
            System.out.println("Please enter in a positive number");
            number = positiveCheck(keyboard); //method call 
            numArray[i] = number; //assigning number to array if its positive
         }catch (InputMismatchException e){ //exception for wrong data type
            System.out.println("Non-integer input, please try again");
            System.out.println();
            numArray[i]=0;
            i--;
         }catch(Exception e){ //Exception for when its a negative number
            System.out.println(e.getMessage());
            numArray[i]=0;
            i--;
         }
         if(i<0){
            i=-1;
         }  
      }
      //Output
      for(int value:numArray){ //finding the total of the values
         total+=value;
      }
      double average = (double)total/5; //finding average 
      System.out.println("The average of those values is "+average);
   }//end of main
   
   //This method takes in a scanner object and checks if its positive, if its not it throws an exception
   public static int positiveCheck(Scanner keyboard) throws Exception{
      Scanner keyboard1 = new Scanner(System.in);
      int number = keyboard1.nextInt();
      if(number<0){
         throw new Exception("Negative input");
      }
      return number;
   }
   
}//end of class