//CSC-101 Project 3 Part 1 
//Purna Chhetri 
//This program finds your monthly payments depending on your loan value, interest rate and years to pay it off

import java.util.Scanner; //scanner for input

class Payment{ //start of class
   public static void main(String[]args){ //start of main
      //Introduction
      System.out.println("Welcome to my payments calculator");
      
      //Objects
      Scanner keyboard = new Scanner(System.in);
      
      //Input on variables and the variables
      System.out.println("Please enter in the initial loan value");
      double initial_loan = keyboard.nextDouble();
      System.out.println("Please enter in the annual interest rate");
      double interest_rate = keyboard.nextDouble();
      System.out.println("Please enter in the years to pay it off");
      double years_payoff = keyboard.nextDouble();
      
      //Calculaitons 
      double monthly_payments = monthlyPayment(initial_loan, interest_rate, years_payoff);
      
      //Printing the results
      System.out.printf("Your monthly payment is $%.2f",monthly_payments);
      System.out.println();
      System.out.println("Goodbye");
      
   } //end of main
   
   public static double monthlyPayment(double initial_loan, double interest_rate, double years_payoff){ //start of method
      //Conversion to month
      double interest_convert = interest_rate/100;
      double interest_monthly = interest_convert/12;
      double months_payoff = years_payoff*12;
      
      //applying the equation 
      double monthly_payment = initial_loan*(interest_monthly*Math.pow((1+interest_monthly),months_payoff))/(Math.pow((1+interest_monthly),months_payoff)-1);
      
      //Returning the result
      return monthly_payment;
            
   } //end of method 
   
} //end of class
