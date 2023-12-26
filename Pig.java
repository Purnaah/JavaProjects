//Purna Chhetri
//CSC-101 Project 4
//This program translate everything you type into pig latin

import java.util.Scanner; //Scanner for input

class Pig{ //Start of class
   public static void main(String[]args){ //Start of main
      
      //Object and variable creation   
      Scanner keyboard = new Scanner(System.in);
      String letter1; 
      char letter;
      //Introduction and promt 
      System.out.println("Welcome to my pig latin translator");
      System.out.println("Please enter a multiple word phrase to translate into pig latin");
      String word = keyboard.nextLine();
      
      //Inserting the word into an array 
      String word_array[] = new String[word.length()];
      for(int i = 0;i<word.length();i++){  //assigns each letter of the word into the array
         letter = word.charAt(i);
         letter1 = Character.toString(letter);
         word_array[i] = letter1;
      }
      
      //Method call on the array
      pigLatin(word_array);
      
      //Outputting the result
      System.out.println("Here is the pig latin equivalent of the phrase:");
      for(String element:word_array){
         System.out.print(element);
      } 
   } //End of main
   
   //This method takes in an array of strings and translates it to pig latin
   public static void pigLatin(String word[]){ //start of method
      
      //Creating a char array of consonants 
      char consonant[] = {'b','B','c','C','d','D','f','F','g','G','h','H','j','J','k','K','l','L','m','M',
      'n','N','p','P','q','Q','r','R','s','S','t','T','v','V','w','W','x','X','y','Y','z','Z'};
      
      //Variables 
      int space_count = 0;
      int sentence_count = 0;
      boolean consonant_check = false;
      boolean consonant_check2 = false;
      boolean vowel_check2 = false;
      boolean vowel_check = false;
      String first_letter = word[0];
      String first_letter2 = "";
      boolean last_sentence = false;
      
      //Checking for spaces to determine how many sentences there are
      for(int i = 0; i<word.length;i++){
         if(word[i].equals(" ")){
            space_count++;
         }
      }
      int total_sentence = space_count+1;   
      
      //Main loop for translating to pig latin
      for(int i = 0; i<word.length;i++){
      
         //First word
         if(i==0){ //checking if its the first word 
            for(int j = 0;j<consonant.length;j++){ //checking if the word is a consonant or vowel
               char letter = word[0].charAt(0); 
               if(letter == consonant[j]){
                  consonant_check = true;
                  j = consonant.length;
               }else if(j==consonant.length-1&&consonant_check==false){
                  vowel_check = true;
               } 
            }
         }
         if(consonant_check==true&&last_sentence==false){ //if the first word is a consonant 
            if(!word[i].equals(" ")){ //when the letter is not a space
               word[i] = word[i+1]; //shifts the letter to the left
            }else{
               word[i-1] = first_letter+"ay"; //when the first space is encountered the first letter replaces the last letter and an ay is added
               consonant_check = false; //setting consonant_check to false after the first word
               sentence_count++;
            }
         }else if(vowel_check == true){ //when the first word is a vowel
            if(word[i+1].equals(" ")){ //adds hay to the last letter of the word
               word[i] = word[i]+"hay";
               vowel_check = false; //setting it to false after the first word
               sentence_count++;
            }
         }
         
         //Any word after the first word
         if(word[i].equals(" ")){ //Finding the start of the word
            first_letter2 = word[i+1]; //Finding the first letter of the word
            for(int k = 0; k<consonant.length;k++){ //Checking if its a consonant or vowel
               char letter2 = first_letter2.charAt(0);
               if(letter2 == consonant[k]){ //Setting the check to true
                  consonant_check2 = true; 
               }else if(k==consonant.length-1){
                  if(consonant_check2==false){
                     vowel_check2 = true;
                  }
               }
            }
         }
         
         //Last word of the sentence
         if(sentence_count+1==total_sentence){ //checking if its the last word
            last_sentence = true; 
            if(consonant_check2 == true||consonant_check == true){ 
               if(!word[i].equals(" ")&&i!=word.length-1){ //shifting the letters to the left
                  word[i] = word[i+1];
               }else if(i==word.length-1&&total_sentence!=1){ //replacing the last letter of word with the first letter and adding ay 
                  word[i] = first_letter2+"ay";
                  consonant_check2 = false;
               }else if(i==word.length-1&&total_sentence==1){ //for when its only one word
                  word[i] = first_letter+"ay";
                  consonant_check2 = false;
               }
            }else if(vowel_check2 == true){
               if(i==word.length-1){
                  word[i] = word[i]+"hay";
                  sentence_count++;
               }
            }   
         }
         
         //If the word is not the first or last word in the sentence
         if(last_sentence == false){
            if(!word[i].equals(" ")){ //Making sure its not a space
               if(consonant_check2 == true){
                  if(!word[i+1].equals(" ")){
                     word[i] = word[i+1];
                  }else if(word[i+1].equals(" ")){
                     word[i] = first_letter2 + "ay";
                     sentence_count++;
                  }
               }else if(vowel_check2 == true){
                  if(word[i+1].equals(" ")){
                     word[i] = word[i]+"hay";
                     sentence_count++;
                  }
               }
            }
         } 
      }
   } //End of method
} //End of class