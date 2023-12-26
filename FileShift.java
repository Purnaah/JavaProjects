//Purna Chhetri
//Lab 12 Part 2
//This program shifts words to the next letter and puts them in a file

import java.util.*; //for scanner 
import java.io.*; //for files and streams

class FileShift{ //start of class
   public static void main(String[] args)throws IOException{ //start of main
      //Input on filename 
      System.out.println("What is the name of the file?");
      Scanner keyboard = new Scanner(System.in);
      String file_name = keyboard.nextLine();
      //Creating file objects
      File file_variable = new File(file_name); //input file
      File file_variable2 = new File("output.txt");
      PrintWriter writer = new PrintWriter(file_variable2);
      FileReader infile = new FileReader(file_variable);
      BufferedReader file_read = new BufferedReader(infile);
      
      //Creating limit variables
      int max_uppercase = (int)'Z';
      int max_lowercase = (int)'z';
      
      //Reading from file and shifting it
      String text = file_read.readLine();
      StringBuilder text2 = new StringBuilder(text);
      for(int i = 0;i<text.length();i++){ 
         char letter = text.charAt(i); //coverting letters into chars
         if(Character.isLetter(letter)){ //checking if they're letters
            int num_value = (int)letter; //coverting letters into their int counterparts
            if(num_value == max_uppercase){ //checking if its the last letter 
               num_value = 64;
            }else if (num_value == max_lowercase){
               num_value = 96;
            }
            num_value++; //adding one, which shifts the letter to the right once
            char new_letter = (char)num_value; //coverting the int back to char
            String new_letter1 = Character.toString(new_letter); //coverting the char into string
            if(i==0){
               text2.replace(0,1,new_letter1); //creating a new string with the new letters
            }else{
               text2.replace(i,i+1,new_letter1);
            }
            
         }
      }
      //Output
      String result = text2.toString(); //new string
      writer.println(result); //writing to output file
      
      //Closing files
      writer.close();
      infile.close();
      file_read.close();
      
   }//end of main
}//end of class