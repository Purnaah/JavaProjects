//Purna Chhetri
//CSC-101 Lab 11
//This program takes input from user and handles exceptions that can occur 

import java.util.*; //For exceptions and scanner 

class InputException{ //start of class
   public static void main(String[] args){ //start of main
      //Objects and variables
      Scanner keyboard = new Scanner(System.in);
      boolean flag = true; 
      //Input from user
      while(flag == true){
         System.out.println("Please input a string(Enter a blank line to stop)");
         String word = keyboard.nextLine();
         if(word.equals("")){
            flag=false;
         }else{
            System.out.println();
            System.out.println("Plase input an index integer");
            //Using charAt
            try{ //catching exceptions that can occur when using charAt
               int index = keyboard.nextInt();
               char letter = word.charAt(index);
               System.out.println("Here is the value in that given index: "+letter); //outputting index value
            }catch (IndexOutOfBoundsException e){ //exception for bad values
               System.out.println("Input is out of bounds or negative, please try a different value");
               System.out.println();
            }catch (InputMismatchException e){
               System.out.println("Wrong type of input, please try again");
               System.out.println();
               keyboard.nextLine();
            }catch (Exception e){ //any other exceptions
               System.out.println("Something went wrong, please try again");
               System.out.println();
            }
         }
      }
      
   } //end of main
} //end of class