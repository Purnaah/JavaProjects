//Purna Chhetri
//CSC-101 Project 2 Part 3
//This program stimulates a rock paper sissors game between a human and robot

import java.util.Scanner; //Scanner for input
import java.util.Random; //Random for creating bot 

class Rock{ //Start of class  
   public static void main(String[]args){ //Start of main method 
      //Creating objects
      Scanner keyboard = new Scanner(System.in);
      Random random = new Random();
      
      //Creating variables
      int score_human = 0;
      int score_computer = 0;
      int rock = 0;
      int paper = 1;
      int sissor = 2;
      int round_counter = 0;
      boolean stop = false;
      
      //Intro 
      System.out.println("Welcome to my game of Rock, Paper, Sissors!");
      //Input on how many rounds to win
      System.out.print("How many winning rounds are needed for victory? :");
      int rounds = keyboard.nextInt();
      //Loop
      while(stop==false){ //the loop will run until the rounds to win is reached
         round_counter++; //adds one to the overall round
         System.out.println("Round# " +round_counter); //prints the current round
         System.out.println("Enter 0=rock,1=paper,2=sissor"); //asking for choice
         int human_choice = keyboard.nextInt(); //assigning the input to a variable
         int computer_choice = random.nextInt(0,3); //creating bot choice 
         //If statements 
         if(human_choice==0){ //Compares the users choice to the computers and prints who won the round or if it was a draw, while adding to the counter
            if(computer_choice==0){
               System.out.println("Human: Rock \t Computer: Rock");
               System.out.println("Draw, try again");
               System.out.printf("Total Score:  Human %d Computer %d",score_human,score_computer);
               System.out.println();
            } else if(computer_choice==1){
               System.out.println("Human: Rock \t Computer: Paper");
               System.out.println("Computer wins this round!");
               score_computer++;
               System.out.printf("Total Score:  Human %d Computer %d",score_human,score_computer);
               System.out.println();
            } else if(computer_choice==2){
               System.out.println("Human: Rock \t Computer: Sissor");
               System.out.println("Human wins this round!");
               score_human++;
               System.out.printf("Total Score:  Human %d Computer %d",score_human,score_computer);
               System.out.println();
            }    
         } else if(human_choice==1){
            if(computer_choice==0){
               System.out.println("Human: Paper \t Computer: Rock");
               System.out.println("Human wins this round!");
               score_human++;
               System.out.printf("Total Score:  Human %d Computer %d",score_human,score_computer);
               System.out.println();
            } else if(computer_choice==1){
               System.out.println("Human: Paper \t Computer: Paper");
               System.out.println("Draw, please try again");
               System.out.printf("Total Score:  Human %d Computer %d",score_human,score_computer);
               System.out.println();
            } else if(computer_choice==2){
               System.out.println("Human: Paper \t Computer: Sissor");
               System.out.println("Computer wins this round!");
               score_computer++;
               System.out.printf("Total Score:  Human %d Computer %d",score_human,score_computer);
               System.out.println();
            }
         } else if(human_choice==2){
            if(computer_choice==0){
               System.out.println("Human: Sissor \t Computer: Rock");
               System.out.println("Computer wins this round!");
               score_computer++;
               System.out.printf("Total Score:  Human %d Computer %d",score_human,score_computer);
               System.out.println();
            } else if(computer_choice==1){
               System.out.println("Human: Sissor \t Computer: Paper");
               System.out.println("Human wins this round!");
               score_human++;
               System.out.printf("Total Score:  Human %d Computer %d",score_human,score_computer);
               System.out.println();
            } else if(computer_choice==2){
               System.out.println("Human: Sissor \t Computer: Sissor");
               System.out.println("Draw, please try again");
               System.out.printf("Total Score:  Human %d Computer %d",score_human,score_computer);
               System.out.println();
            }
         }
         if(score_human==rounds){
            System.out.printf("It took %d rounds, but you won!",round_counter);
            System.out.println();
            System.out.println("Goodbye, play again sometime");
            stop=true; //ends the loop
         } else if(score_computer==rounds){
            System.out.printf("It took %d rounds for the computer to beat you, get better",round_counter);
            System.out.println();
            System.out.println("Goodbye, play again sometime");
            stop=true; //ends the loop
         }       
      } //end of while loop
   
   } //end of main
} //end of class
