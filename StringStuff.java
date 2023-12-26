//Purna Chhetri
//CSC-101 Project #1 Part 3
//This program manipulates words and does cool stuff with them 

import java.util.Scanner; //importing scanner for user input
import java.util.Random; //importing random to generate random numbers to be used in the program

class StringStuff{ //start of class
   public static void main(String[]args){ //start of main
   
      //Creating objects
      Scanner user_input = new Scanner(System.in); //creating scanner object
      Random random = new Random(); //creating random object
   
      //Introduction
      System.out.println("Welcome to my string manipulator program"); //intro statement
      System.out.println("Please enter in multiple words"); 
      String word = user_input.nextLine(); //getting user input and assigning it to a variable
   
      //The length of the words given
      int the_length = word.length(); //getting the length of the given string
      System.out.println("The length of the string is: "+the_length); //outputting the length
   
      //Locations of the first and last letters of the string
      int first_word = 2; //location of the 2nd letter
      int last_word = the_length - 1; //location of the last letter
      String sub_string = word.substring(first_word,last_word); //making it so the first letter and last letter are missing
      System.out.println("Here is the string with the first and last letter missing: "+sub_string); //outputting the result
   
      //Setting the min and max value for the random object
      int min_value = 0; 
      int max_value = the_length; 
      
      int random_num = random.nextInt(min_value, max_value); //creating the random object 
      int random_num_two = random_num+1; //adding one to the random number 
   
      //Outputting random letters from the given string
      String random_letter = word.substring(random_num,random_num_two); //getting a random letter
      System.out.println("Random letter from the string: " + random_letter); //printing the random letter
   
      //Finding the first space within the string
      int space_location = word.indexOf(" ");
      System.out.println("Index of the first space: "+space_location); //printing out the first space location
      
      System.out.println(); //blank line
      System.out.println("Thank you for using my program! See you next time!");
  
   } //end of main
} //end of class