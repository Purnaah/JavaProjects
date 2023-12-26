//Purna Chhetri
//CSC-101 Project 2 Part 2
//This program prints out all the prime numbers within given range 

import java.util.Scanner; //Scanner for input

class Prime{ //start of class
   public static void main(String[]args){ //start of main method 
      //Objects 
      Scanner keyboard = new Scanner(System.in);
      
      //Variables
      int one = 1;
      int two = 2;
      int counter = 0;
      int primes_found = 0;
      //Intro 
      System.out.println("This program will search for prime numbers within a given range.");
       
      //Input on bounds 
      System.out.println("Please enter in the lower bound for the search");
      int lower_bound = keyboard.nextInt();
      System.out.println("Please enter in the upper bound for the search");
      int upper_bound = keyboard.nextInt();
      System.out.println("Primes found:");
      //Loop 
      
      for(int num = lower_bound; num<= upper_bound;num++){  //start of for loop
         if(num/one == num){ //checks if divisible by one
            for(int j = 1; j<num;j++){ //nested for loop, it divides the given number with lower numbers until it reaches the given number
               if(j!=1){ //making sure the number isn't divded by 1
                  int check = num%j; //dividing the number by j(which increases by one every loop until j is equal to the number)
                  if(j==num-1){ 
                        if(counter==0){ //when j is one less than the given number, the counter is checked and if its still 0, the number is prime
                           System.out.println(num); //the prime number is printed
                           primes_found++; //adding  one to the prime counter
                        }
                  }
                  if(check==0){ //adds one to counter every time the number is divisible by an another number 
                     counter++;
                     if(counter==1){ //if its divisible by an another number besides 1, its not a prime number, so the loop ends 
                        j=num;
                        counter = 0; //the counter is reset 
                     }   
                  }               
               }
            } 
         } //end of if     
      } //end of loop  
      
      //Outputting how many primes found in the given range
      System.out.printf("There were %d primes found between %d and %d",primes_found, lower_bound, upper_bound);
      System.out.println();
      
      //Goodbye 
      System.out.println("Thank you for using my program!");
         
   } //end of main
} //end of class   