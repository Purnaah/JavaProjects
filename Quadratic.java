//Purna Chhetr
//Lab 11 Bonus Question
//This program solves the quardratic equation

import java.util.*; //importing scanner for user input and for exceptions

class Quadratic{ //start of class
   public static void main(String[]args){ //start of main
      
      //Introduction
      System.out.println("Welcome to Purna's quadratic equation solver.");
      System.out.println("This program will solve equations of the form < A*x^2 + B * x + C = 0 > for the variable x."); 
      System.out.println();                                       
      
      //Creating objects and varibles and arrays
      Scanner userInput = new Scanner(System.in);
      double numberArray[] = new double[2];
      boolean flag = true;                                                                                                                                            
      
      //Loop
      while (flag == true){
         //Try block
         try{
            //Input on variables
            System.out.println("Please enter the variable in order of A,B, and C.");
            double variable_a = userInput.nextDouble();
            double variable_b = userInput.nextDouble();                      
            double variable_c = userInput.nextDouble();
            
            //Calling method
            numberArray = quadraticSolver(variable_a,variable_b,variable_c);
            
            //Displaying the input
            System.out.println("You have entered: ");
            System.out.println("A="+variable_a);
            System.out.println("B="+variable_b);                                             
            System.out.println("C="+variable_c);
            System.out.printf("Here are those values plugged into the equation %.2f*x^2+%.2f*x + %.2f = 0",variable_a, variable_b,variable_c);
            System.out.println();
            
            //Displaying the result
            System.out.println("The solututions are:");
            System.out.printf("x = %.2f",numberArray[0]);
            System.out.println();
            System.out.printf("x =%.2f",numberArray[1]);
            System.out.println();
            System.out.println("Thank you for using my solver");
            
            //Stopping loop 
            flag = false;
            
         }catch (IllegalArgumentException e){ //catching exceptions
            System.out.println(e.getMessage());
            
         }catch (InputMismatchException e){
            System.out.println("Wrong data type inputted, please try again");
            
         }catch (Exception e){
            System.out.println("Something went wrong");  
         }
      } //end of loop
                     
   } //end of main
   
   public static double[] quadraticSolver(double variable_a, double variable_b, double variable_c) throws IllegalArgumentException {
      //Creating array to return
      double[] numArray = new double[2];
      
      //Checking if b^2-4ac is negative
      double negative_check = (Math.pow(variable_b,2))-(4*variable_a*variable_c);
      
      //Checking if a is 0
      if(variable_a == 0){
         throw new IllegalArgumentException("A cannot be 0");
      }else if(negative_check<0){
         throw new IllegalArgumentException("b^2*4ac is negative, please try different values");
      }else{
         double solution_plus = (-(variable_b)+Math.sqrt(Math.pow(variable_b,2)-4*variable_a*variable_c))/(2*variable_a);
         double solution_minus = (-(variable_b)-Math.sqrt(Math.pow(variable_b,2)-4*variable_a*variable_c))/(2*variable_a);
         numArray[0] = solution_plus;
         numArray[1] = solution_minus;
         return numArray;
      }
   }
}//end of class   
 
      