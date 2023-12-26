//CSC-101 Project 3 Part 1 
//Purna Chhetri 
//This program picks a word out of a sentence depending on the number entered

import java.util.Scanner; //scanner for input

class PickWord{ //start of class
   public static void main(String[]args){ //start of main
      //Introduction
      System.out.println("Welcome to word calculator");
      
      //Objects
      Scanner keyboard = new Scanner(System.in);
      
      //Asking for input
      System.out.println("Please input a sentence with mulitple words");
      String word = keyboard.nextLine();
      StringBuilder sentence = new StringBuilder(word);
      System.out.println("Please input an integer");
      int num = keyboard.nextInt();
      
      //Application of method
      String output = wordReturner(sentence, num);
      
      //Outputting results
      System.out.printf("Here is the %dth word from that sentence: %s",num,output);
      System.out.println(); 
      System.out.println("Goodbye, thank you for using my program");
      
   } //end of main
   
   public static String wordReturner(StringBuilder sentence, int num){
      //Variable 
      int space_count = 0;
      int index_location = 0;
      int index_location2 = 0;
      int index_location3 = 0;
      int index_location_prior = 0;
      int index_location4 = 0;
      int check = 0;
      StringBuilder result = sentence;
  
      //Loop
      if(num<=0){ //empty string for 0 or less
         String four = "";
         result = new StringBuilder(four);
      }else if(num==1){ //if the number is 1
         for(int a = 0; a<sentence.length();a++){ //loops the sentence until the first space is found
            char letter5 = sentence.charAt(a);
            if (Character.isWhitespace(letter5)==true){ //checking for space
               index_location4 +=a; //index location of the space
               String four = result.substring(0,index_location4); //getting the word using substring
               result = new StringBuilder(four); //assigning it the variable result
               a += sentence.length(); //ending the loop
            }
         }
      }else{ //any other number
         for (int i = 0; i<num;i++){ 
            while (space_count<num){ //loops until the space count is equal to the number
               for(int j = 0; j< sentence.length();j++){ //looping the sentence
                  char letter = sentence.charAt(j); //looping through each letter
                  if (Character.isWhitespace(letter)== true){ //checking for spaces
                     space_count++; //adding one whenever a space is encountered 
                     if(space_count==num){ //checking if space count equals the number entered 
                        index_location += j; //finding the location of that space
                        check++; //adding one to counter for output later
                        index_location_prior = index_location-1; //subtracting one from that index
                        for(int p = index_location_prior;p<=index_location_prior;p--){ //looping backwards until a space is found
                           char letter3 = sentence.charAt(p);
                           if (Character.isWhitespace(letter3)== true){ //checking for spaces
                              index_location3 += p; //finding the index of the space 
                              j = sentence.length()+1; //ending loop
                              space_count = num+1;  //ending loop
                              p = index_location_prior+5; //ending loop
                           }
                        } 
                     }
                  }   
               }
               if(num>space_count){ //if the number is larger than the amount of spaces in the sentence
                  for(int k = sentence.length()-1;k>index_location2;k--){ //looping backwards from the end of sentence
                     char letter2 = sentence.charAt(k);
                     if(Character.isWhitespace(letter2)){ //checking for spaces 
                        index_location2 += k; //finding location of space
                        check+=3; 
                        space_count = num+1; //ending loop
                     }    
                  }
               }   
            }  
         }
         //Checking which result to return
         if (check==1){
            String four  = result.substring(index_location3+1,index_location);
            result = new StringBuilder(four);
         }else{
            String four = result.substring(index_location2+1,sentence.length()); 
            result = new StringBuilder(four);
         }
      }
      String answer = result.toString(); //converting to string
      return answer; //returning the string
      
   }//end of method   
} //end of class  
    