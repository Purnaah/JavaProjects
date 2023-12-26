//Purna Chhetri
//CSC-101 Project 4 
//This program simulates a hangman game
import java.util.Scanner; //Scanner for input

class Hangman{ //Start of class
   public static void main(String[]args){ //Start of main
      
      //Objects and variables
      Scanner keyboard = new Scanner(System.in);
      int wrong_counter = 0;
      int correct_counter = 0;
      int total_correct_guesses = 0;
      int guess_letter_counter = 0;
      int array_counter = 0;
      int guesses_left = 0;
      int space_counter = 0;
      
      //Introdcution
      System.out.println("Welcome to my hangman game");
      System.out.println("One player will choose a hidden word or phrase and the other player will try to guess it");
      //Input
      System.out.println("What is the hidden word or phrase?");
      String word = keyboard.nextLine();
      System.out.println("What is the allowed amount of missed guesses?");
      int missed_guesses = keyboard.nextInt();
      StringBuilder word1 = new StringBuilder(""); //creating StringBuilder for later use 
      
      //Char array
      int word_length = word.length(); //finding the length of the word
      char letters[] = new char[word_length]; //creating a char based on length of the word
      char check_letters[] = new char[word_length]; //array for checking if letter is already used
      
      //For Loops
      for(int i = 0; i<word_length;i++){  //assigns each letter of the word into the array as a char
         letters[i] = word.charAt(i);
      }
      
      for(int i = 0; i<word.length();i++){ //creates a StringBuilder with dashes based on the length of word
         if(letters[i]==' '){
            word1.append("  ");
         }else{
            word1.append("_ ");
         }
      } 
            
      for(int i = 0; i<word_length;i++){ //loop for finding how many spaces there are
         if(letters[i]==' '){
            space_counter++;
         }
      }
      
      //While loop
      while(wrong_counter<missed_guesses && total_correct_guesses<word_length-space_counter){ /*runs until user reaches the allowed amount of incorrect choices
      or gets all of the letters in the phrase*/

         //Status and Input
         System.out.println("Current status:");
         System.out.println(word1);
         System.out.println("What is your guess?");
         String guess = keyboard.next();
         char guess_letter = guess.charAt(0);
         char guess_letter_lowercase = Character.toLowerCase(guess_letter); 
         //Loops
         for(int i = 0; i<check_letters.length;i++){  //checks if the word has already been used
            if(guess_letter_lowercase==check_letters[i]){
               guess_letter_counter++;
            }
         }
         if(guess_letter_counter>=1){ //if the user tries to guess the same letter twice
            System.out.println("You have already guessed that letter, please try again");
            guess_letter_counter = 0;
            wrong_counter++;
            guesses_left = missed_guesses-wrong_counter;
            System.out.printf("You have %d guesses left",guesses_left);
            System.out.println();
            if(guesses_left==0){
               System.out.println("You have no more guesses remaining and have lost the game");
               System.out.printf("The hidden word was: %s",word);
            }
         }else{
            for(int i = 0; i<word_length;i++){  //checks if the letter guess is in the letter array
               char letter_lowercase = Character.toLowerCase(letters[i]);
               char guess_lowercase2 = Character.toLowerCase(guess_letter);
               if(letter_lowercase == guess_lowercase2){
                  correct_counter++;
                  total_correct_guesses++;
                  System.out.println("You have guessed a correct letter");
                  word1.setCharAt(i*2,letters[i]); //edits the StringBuilder so the letter is inserted
               }
            }
            if(correct_counter==0){ //if the letter is not in the word
               wrong_counter++;
               System.out.println("You have guessed incorrectly and used one of your gusses");
               guesses_left = missed_guesses-wrong_counter;
               if(guesses_left==0){
                  System.out.println("You have no guesses remaining and have lost");
                  System.out.printf("The hidden word was: %s",word);
               }else{
                  System.out.println("You have "+guesses_left+" guesses left");
               }
            }else if(total_correct_guesses==word_length-space_counter){
               System.out.println("The word: "+word1);
               System.out.println("Congrat! you have guessed every letter of the word and won");
            }
            //Resetting the counters/adding to them
            correct_counter = 0;
            guess_letter_counter = 0;
            check_letters[array_counter] = guess_letter;
            array_counter++;
         }
      }
   } //End of main
} //End of class