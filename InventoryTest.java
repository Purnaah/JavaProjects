//Purna Chhetri
//CSC=101 Lab 9 Part 1
//Class testing

class InventoryTest{ //start of main method 
   public static void main(String[]args){
      
      //Array 
      Inventory items[] = new Inventory[5];
      
      //Setting the array with first constructor 
      items[0] = new Inventory("Spoon", 14, 1.25);
      items[1] = new Inventory("Fork", 18, 1.50);
      items[2] = new Inventory("Knife", 12, 2.35);
      
      //Setting the array with second constructor 
      items[3] = new Inventory("Dish", 5.95);
      items[4] = new Inventory("Bowl", 4.99);
      
      //Using modifer 
      items[1].setPrice(1.75);
      items[3].setQuantity(5);
      items[4].setQuantity(8);
      items[2].setDescription("Butter Knife");
      
      //Output loop
      for(int i = 0;i<items.length;i++){
         System.out.printf("We have %d %s (s) at a price of $%.2f",items[i].getQuantity(),items[i].getDescription(),items[i].getPrice());
         System.out.println();
      }   
   
   }//end of main method

}//end of class