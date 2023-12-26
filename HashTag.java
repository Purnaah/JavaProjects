//Purna Chhetri
//CSC 101 Lab 7 Part 3

import java.util.Scanner; //input

class HashTag{ //start of class
   public static void main(String[]args){ //start of main
      
      //Objects
      Scanner keyboard = new Scanner(System.in);
      
       //Input
      System.out.println("Please enter in a sentence");
      StringBuilder word = new StringBuilder(keyboard.nextLine());
      
      //Length of word
      int length = word.length(); 
      
      //Loop
      for(int i = 0;i<length;i++){
         char letter = word.charAt(i);
         if(letter == 'a' || letter == 'A' || //checking if the letter is a vowel
            letter == 'e' || letter == 'E' ||
            letter == 'i' || letter == 'I' ||
            letter == 'o' || letter == 'O' ||
            letter == 'u' || letter == 'U'){
            char letter_hashtag = '#';
            word.setCharAt(i,letter_hashtag); //changing the letter to # if its a vowl
         }   
      }
      
      //Output
      System.out.println("Here is the sentence with the vowel replaced with #");
      System.out.println(word);
      System.out.println("Goodbye");
      
   } //end of main
} //end of class
