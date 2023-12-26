//Purna Chhetri
//CSC 101 Lab 7 Part 1
//This program checks if a word is a palindrome

import java.util.Scanner; //input

class Palindrome{ //start of class
   public static void main(String[]args){ //start of main
      
      //Objects
      Scanner keyboard = new Scanner(System.in);
      
      //Variables
      int loop_amount = 0;
      int total_first = 0;
      int total_last = 0;
      
      //Input
      System.out.println("This program checks if a word is a palindrome");
      System.out.println("Please enter in a word");
      String word_original = keyboard.nextLine(); 
      String word = word_original.toUpperCase(); //changing the input to all lowercase
      
      //Checking if even or odd
      int length = word.length(); //length of word
      
      if(length%2==0){  //checking if the length of word is even
         int divide = length/2;
         loop_amount += divide; //how many times to loop
         
         for (int i = 0; i<loop_amount;i++){ //first half of the word
            char letter = word.charAt(i); //getting the letter
            int num = (int)(letter); //converting it to int
            total_first += num; //adding the int to a counter
         }
         for (int j = length-1; j>=loop_amount; j--){ //second half of the word
            char letter = word.charAt(j); 
            int num = (int)letter;
            total_last += num;
         }
      }else{ //if the  length of word is odd
         int subtract = (length-1)/2;
         loop_amount += subtract;
         
         for (int i = 0; i<loop_amount;i++){
            char letter = word.charAt(i);
            int num = (int)(letter);
            total_first += num;
         }
         for (int j = length-1; j>loop_amount; j--){
            char letter = word.charAt(j);
            int num = (int)letter;
            total_last += num;
         }      
      }
      
      //checking if its a palindrome and outputting result
      if (total_first == total_last){
         System.out.println("The word is a palindrome");
      }else{
         System.out.println("The word isn't a palindrome");
      }
      
   } //end of main
} //end of class   