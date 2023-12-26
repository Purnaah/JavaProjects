//Purna Chhetri
//CSC-101 Lab 9
//This lab reverses the status of mailboxes and reports how many remained closed

import java.util.Scanner; //Scanner for input
class Mailbox{ //Start of class
   public static void main(String[]args){ //Start of main
      //Objects and variables
      Scanner keyboard = new Scanner(System.in);
      int total_closed = 0;
      
      //Intro and input
      System.out.println("Welcome to my program");
      System.out.println("Please enter in the amount of mailboxes you want:");
      int num = keyboard.nextInt();
      
      //Creating the array for mailbox
      boolean mailbox[] = new boolean[num];
      
      //Closing all the mailboxes
      for(int i = 0; i<num; i++){
         mailbox[i]=true;
      }
      
      //Reversing the state of the boxes
      for(int j = 2;j<=num;j++){
         for(int k=j-1;k<num;k+=j){
            if(mailbox[k]==true){
               mailbox[k]=false;
            }else if(mailbox[k]==false){
               mailbox[k]=true;
            }    
         }       
      }
      //Counting how many remain closed
      for(int i = 0; i<num;i++){
         if(mailbox[i]==true){
            total_closed+=1;
         }
      }
      
      //Outputting the status of the mailboxes
      System.out.println("Here are all the mailboxes and their status:");
      for(int i = 0; i<num;i++){
         System.out.println(i+1+". "+mailbox[i]);
      }
      //Outputting 
      System.out.printf("There were a total of %d closed boxes", total_closed);
      
   } //End of main
} //End of class