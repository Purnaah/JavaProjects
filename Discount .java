//Purna Chhetri
//CSC-101 Project #2 Part 1
//This program calculates the price of bags of coffee including discounts and cost of boxes

import java.util.Scanner; //Importing scanner for keyboard input

class Discount{ //start of class
   public static void main(String[]args){ // start of main method
      
      //Objects, variables, and constants 
      Scanner keyboard = new Scanner(System.in); //scanner object
   
      final double PRICE_PER_BAG = 5.50; //contants and vairables 
      final int LARGE_BOX = 20;
      final int MEDIUM_BOX = 10;
      final int SMALL_BOX = 5;
      final double PER_BOX_LARGE = 1.80;
      final double PER_BOX_MEDIUM = 1.00;
      final double PER_BOX_SMALL = 0.60;
      final double DISCOUNT_5 = 0.05;
      final double DISCOUNT_10 = 0.1;
      final double DISCOUNT_15 = 0.15;
      final double DISCOUNT_20 = 0.20;
      final double DISCOUNT_25 = 0.25;
      final double DISCOUNT_30 = 0.30;
      int conversion = 100;
      double overall_price = 0;
   
      //Introduction
      System.out.println("This program will calculate total cost of the purchase of coffee bags."); 
      System.out.println("Please enter the amount of bags you wish to purchase:");
   
      //Input for bags
      int bags = keyboard.nextInt();
   
      //Calculating the raw price 
      double price_raw = bags*PRICE_PER_BAG;
      
      //Outputting the raw price and bag amount
      System.out.printf("Number of Bags Ordered: \t%d-\t $ %.2f", bags, price_raw);
      System.out.println();
      
      //Discount 
      if(bags>= 25 && bags<=49){ //start of if statement 
         double discount = price_raw*DISCOUNT_5; //mulitplying the raw price by the appropriate discount 
         double discount_converted = DISCOUNT_5*conversion; //mulitplying the decimal discount values by 100 so it can be displayed
         System.out.printf("Discount: \t%.0f%%-\t $ %.2f", discount_converted, discount); //displaying the discount and how much the discount took off
         System.out.println(); //next line
         double price_actual = price_raw - discount; //price after discount
         overall_price += price_actual; //adding it to the overall price 
      } else if (bags>= 50 && bags<=99){ 
         double discount = price_raw*DISCOUNT_10; //same concept as above for all the else if statements
         double discount_converted = DISCOUNT_10*conversion;
         System.out.printf("Discount: \t%.0f%%-\t $ %.2f", discount_converted, discount); 
         System.out.println();
         double price_actual = price_raw - discount;
         overall_price += price_actual;
      } else if (bags>= 100 && bags<=149){
         double discount = price_raw*DISCOUNT_15;
         double discount_converted = DISCOUNT_15*conversion;
         System.out.printf("Discount: \t%.0f%%-\t $ %.2f", discount_converted, discount); 
         System.out.println();
         double price_actual = price_raw - discount;
         overall_price += price_actual;
      } else if (bags>= 150 && bags<=199){
         double discount = price_raw*DISCOUNT_20;
         double discount_converted = DISCOUNT_20*conversion;
         System.out.printf("Discount: \t%.0f%%-\t $ %.2f", discount_converted, discount); 
         System.out.println();
         double price_actual = price_raw - discount;
         overall_price += price_actual;
      } else if (bags>= 200 && bags<=299){
         double discount = price_raw*DISCOUNT_25;
         double discount_converted = DISCOUNT_25*conversion;
         System.out.printf("Discount: \t%.0f%%-\t $ %.2f", discount_converted, discount); 
         System.out.println();
         double price_actual = price_raw - discount;
         overall_price += price_actual;
      } else if (bags>= 300){
         double discount = price_raw*DISCOUNT_30;
         double discount_converted = DISCOUNT_30*conversion;
         System.out.printf("Discount: \t%.0f%%-\t $ %.2f", discount_converted, discount); 
         System.out.println();
         double price_actual = price_raw - discount;
         overall_price += price_actual;
      } else{ 
         System.out.println("Invalid response please try a different number"); 
      }  //end of if 
      //Variables for the nested statement
      int number_needed_large = 0;   
      int number_needed_medium = 0;
      int number_needed_small = 0;
      //Applying box prices
      if(bags>=20){ //start of if, only applicable if there's over 20 bags
         int amount_needed_large = bags/LARGE_BOX; //dividing the bags by how much a large box can fit 
         number_needed_large += amount_needed_large; //adding the amount of large box needed to the counter 
         int amount_leftover = bags%LARGE_BOX; //finding how many boxs are left 
         if(amount_leftover >= MEDIUM_BOX){ //if the amount leftover is greater than 10, medium boxes are used
            int amount_needed_medium = amount_leftover/MEDIUM_BOX; //same concept as above 
            number_needed_medium += amount_needed_medium; 
            int amount_leftover_medium = amount_leftover%MEDIUM_BOX;
            if(amount_leftover_medium>=1 && amount_leftover_medium<=SMALL_BOX){ //if there are less than 5 bags left, one small box is used
               number_needed_small++; 
            }else if(amount_leftover_medium>SMALL_BOX){ //if there are more than 5 bags but less than 10, 2 small boxes are used
               number_needed_small+=2;
            }
         }else if (amount_leftover>=1 && amount_leftover<=SMALL_BOX){ //if there are less than 10 bags left after large boxes are used 
                  number_needed_small++;
         }else if(amount_leftover>SMALL_BOX){
               number_needed_small+=2;
         } 
      } //end of if  
      
      //Calculating overall total by adding the price of the bags
      double adding_large = number_needed_large*PER_BOX_LARGE;
      double adding_medium = number_needed_medium*PER_BOX_MEDIUM;
      double adding_small = number_needed_small*PER_BOX_SMALL;
      double overall_total = adding_large + adding_medium + adding_small + overall_price;
      
      //Printing the boxes needed and their price 
      System.out.println("Boxes used:");
      System.out.printf(" %d Large- \t $%.2f", number_needed_large, adding_large);
      System.out.println();
      System.out.printf(" %d Medium- \t $%.2f", number_needed_medium, adding_medium);
      System.out.println();
      System.out.printf(" %d Small- \t $%.2f", number_needed_small, adding_small);
      System.out.println();
      
      //Printing out the total
      System.out.printf("Your total charge is: \t $%.2f", overall_total);
      System.out.println();
      System.out.println("Thanks for using my cost calculator!");
    
   } //end of main method 
} //end of class
