//Purna Chhetri
//CSC-101 Project 4 
//This program generates 1000 random number between(and including) 1 and 50, finding which numbers occured the most often

import java.util.Scanner; //Scanner for input
import java.util.Random;  //importing random class for random numbers

class MaxArray{ //Start of class
   public static void main(String[]args){ //Start of main
      //Creating scanner object
      Scanner keyboard = new Scanner(System.in);
      
      //Introduction
      System.out.println("Welcome to my program");
      System.out.println("This program will generate 1000 random numbers between 1 and 50");
      
      //Creating random object
      Random rand = new Random(1);  //create random object and sets seed to one
      int random_number = 0; 
      int max_num = 0;
      int num = 0;
      int larger_num = 0;
      int fifty_counter = 0;
      
      //Creatubg arrays
      int numArray[] = new int[1000];
      int counter[] = new int[51];
      
      //Looping through the array and assigning random number to the elements
      for(int i = 0;i<numArray.length;i++){ //assigns a random number to the array
            random_number = rand.nextInt(50)+1;
            numArray[i] = random_number;
            if(numArray[i]==50){
               fifty_counter++;
            }
      }
      
      //Adding one to counter every time that number is encountered 
      for(int i = 1;i<51;i++){
         for(int j = 0;j<numArray.length;j++){
            if(numArray[j] == i){
               counter[i]++;
            }
         }
      }
      
      //Output statement
      System.out.println("Here are the 10 numbers that occured the most and the amount of times they occured: ");
      
      //Finding the ones that occured the most
      for(int i = 1;i<=10;i++){ //Setting how many of them I want to display
         for(int j = 0;j<51;j++){ //finding the largest 
            if(j == 0){
               max_num = counter[0];
            }else{
               larger_num = Math.max(max_num,counter[j]);
               max_num = larger_num;
            }
         }
         for(int k = 1; k<51;k++){ //Displaying the largest, setting it to 0 after its displayed
            if(counter[k] == max_num){
               System.out.printf("%d. the number %d which occured %d times",i,k,max_num);
               System.out.println();
               counter[k] = 0; 
               k=51; //ending loop
            }
         }   
      }
      System.out.println(fifty_counter);
               
   } //End of main
} //End of class