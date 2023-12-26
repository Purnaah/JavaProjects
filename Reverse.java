//Purna Chhetri
//CSC 101 Lab 7 Part 2
//This program reverses your string inputs

import java.util.Scanner; //input
class Reverse{ //start of class
   public static void main(String[]args){ //start of main
      //Objects
      Scanner keyboard = new Scanner(System.in);
      
      //Input
      System.out.println("Please enter in a sentence");
      StringBuilder word = new StringBuilder(keyboard.nextLine()); //converting it to string builder
      
      //length
      int length = word.length(); //getting length of the word
      
      //Loop
      for(int i = 0;i<length;i++){
         char letter = word.charAt(i);
         if(Character.isUpperCase(letter)){ //checks if character is uppercase
            char letter_lower = Character.toLowerCase(letter); //changes to lowercase if its uppercase
            word.setCharAt(i,letter_lower); // changing the stringbuilder
         }else{
            char letter_upper = Character.toUpperCase(letter); //sets it to uppercase if its lowercase
            word.setCharAt(i,letter_upper);
         }    
      }
      
      //Output
      System.out.println("Here is the sentence with all the letters reversed");
      System.out.println(word);
      System.out.println("Goodbye");
       
   } //end of main
} //end of class