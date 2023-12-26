//Purna Chhetri
//CSC=101 Lab 9 Part 1
//Class creation

class Inventory{ //start of class
   
   //Data members
   private String description;
   private int quantity; 
   private double price;
   
   //Constructors 
   public Inventory(String word, int amount, double cost){
      description = word;
      quantity = amount;
      price = cost;  
   }
   public Inventory(String word, double cost){
      description = word;
      quantity = 0;
      price = cost;
   }
   
   //Accessor methods
   public String getDescription(){
      return description;
   }
   public int getQuantity(){
      return quantity;
   }
   public double getPrice(){
      return price;
   }
   
   //Modifier methods
   public void setDescription(String word){
      description = word;
   }
   public void setQuantity(int amount){
      quantity = amount;
   }
   public void setPrice(double cost){
      price = cost;
   }
   
   //toString method
   public String toString(){
      return "Description: "+description+"Quantity: "+quantity + "Price: "+price;
   }
   
} //end of class