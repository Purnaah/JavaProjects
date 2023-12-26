//Purna Chhetri
//CSC-101 Project 5 
//This program creates a class with methods for polynomials 
class Polynomial{ //Start of class
   //Private data members
   private double coefficient[];
   private int degree;
   
   //Constructors 
   public Polynomial(){ //default values 
      degree = 0;
      coefficient = new double[1];
   }
   public Polynomial(String number){ //allowing user to set starting values
      setCoeff(number); //using modifier method to set degree and coefficient 
   }
   
   //Accessors
   public double[] getCoeff(){ //gets coefficient 
      return coefficient;   
   }
   public int getDegree(){ //gets degree
      return degree;
   }
   
   //Modifier 
   public void setCoeff(String number){ // this method sets the degree and coefficient based on the string inputted 
      int num = 0; //place holder for degrees
      int extra_zeros = 0; //any trailing zeros
      boolean flag = true; 
      int index = 0;
      for(int i = 0;i<number.length();i++){ //counting spaces to see how many values there are
         char value = number.charAt(i);
         if(Character.isWhitespace(value)){
            num++;
         }
      }
      String[] number_array = number.split(" "); //usinig split method to split the string into an array
      double[] coefficient_raw = new double[number_array.length]; //array with trailing zeros
      for(int j = 0;j<number_array.length;j++){ //parsing string into double
         double coeff = Double.parseDouble(number_array[j]);
         coefficient_raw[j] = coeff;
         if(j == number_array.length-1 && coefficient_raw[j] == 0 && num!=0){ //count all the trailing zeros
            index = j;
            extra_zeros++;
            while(flag == true){
               index--;
               if(coefficient_raw[index]==0){
                  extra_zeros++;
               }else{
                  flag = false;
               }
            }
         }
      }
      coefficient = new double[coefficient_raw.length-extra_zeros]; //creating new array without trailing zeros
      for(int k = 0;k<coefficient.length;k++){//assigning values into the new array
         coefficient[k] = coefficient_raw[k];
      }
      degree = num-extra_zeros; //setting the degree
   }
   
   //Instance method
   public Polynomial add(Polynomial term){ //adds two polynomial objects
      int lowest_degree = Math.min(this.getDegree(),term.getDegree());
      int highest_degree = Math.max(this.getDegree(),term.getDegree()); //finding the highest and lowest degrees
      Polynomial new_term = new Polynomial(); //creating the new object that will be returned
      new_term.coefficient = new double[highest_degree+1]; 
      for(int i = 0;i<=highest_degree;i++){  //setting the coefficient of new object
         if(i<=lowest_degree){
            new_term.coefficient[i] = this.coefficient[i]+term.coefficient[i];   
         }else{
            if(this.getDegree()<term.getDegree()){
               new_term.coefficient[i] = term.coefficient[i];
            }else{
               new_term.coefficient[i] = this.coefficient[i];
            }
         }
      }
      new_term.degree = highest_degree; 
      return new_term; //returning new object
   }
   public String toString(){ //shows what a string version of the polynomial would look like
      StringBuilder function = new StringBuilder(""); //creating a blank stringbuilder
      for(int i = 0;i<=degree;i++){ //loop for editing stringbuilder object
         if(degree == 0 && coefficient[0] == 0){ //if there's only one value and its zero
            function.append("f(x)= 0.0");
         }else{
            if(i==0){ //if the first value is zero
               function.append("f(x)= ");
               if(coefficient[i]==0){
                  function.append(""); //outputs a blank string for it
               }else{
                  function.append(coefficient[i]); //if its not zero, displays the value
               }
            }else if(i==1 && coefficient[i]<0){ //if its the second value and its negative
               function.append(coefficient[i]+"x");
            }else if(i==1 && coefficient[i]>0){ //second value positive
               if(coefficient[0]==0){
                  function.append(coefficient[i]+"x");
               }else{
                  function.append("+"+coefficient[i]+"x");
               }
            }else if(i==1 && coefficient[i]==0){ //second value is zero
               function.append("");
            }else if(i>1 && coefficient[i]<0){ //any other value after 2nd value and its negative
               function.append(coefficient[i]+"x^"+i);
            }else if(i>1 && coefficient[i]==0){ //any other value after 2nd value and its zero
               function.append("");
            }
            else{ //any other value after 2nd value and its positive
               function.append("+"+coefficient[i]+"x^"+i);
            }
         }
      }   
      //Converting to string
      String function1 = function.toString(); 
      
      return function1; //returning string
   }
   public double evaluate(double number){ //this method evaluates the function to a given value of x
      double result = 0; //counter
      for(int i = 0;i<coefficient.length;i++){ //evaluates using the number given
         if(i!=0){
            result+=coefficient[i]*Math.pow(number,i);
         }
      }
      result+=coefficient[0]; //adding the first value to result
      return result; //returning result
   }
   public Polynomial derivative(){ //finds the derivative of the function
      Polynomial function = new Polynomial(); //creating new object to return
      Polynomial function_derivative = this.add(function); //giving the new function the current objects value
      for(int i = 0; i<=this.coefficient.length;i++){ //finding the derivative 
         if(i == 0){
            function_derivative.coefficient[i] = 0; //first value to zero 
         }else if(i==this.coefficient.length){
            function_derivative.coefficient[i-1] = 0;//setting last value to zero
         }else{
            function_derivative.coefficient[i-1] = (this.coefficient[i]*i); //applying derivative rule
         }
      }
      return function_derivative; //returning new object
   } 
   public double findRoot(double number){ //this method finds the root of polynomial with an initial guess
      //Variables and objects
      double current_value = 0;
      double previous_value = 0;
      double initial_guess = number;
      double function_evaluate = 0;
      double derivative_evaluate = 0;
      Polynomial function_derivative = this.derivative(); //getting derivative of polynomial
      //Loop
      for(int i = 0;i<1000;i++){ //applying Newton-Raphson method
         if(i==0){
            current_value = initial_guess;
         }else{
            previous_value = current_value;
            function_evaluate = this.evaluate(current_value);
            derivative_evaluate = function_derivative.evaluate(current_value);
            current_value = current_value-(function_evaluate/derivative_evaluate);
            double check = Math.abs(current_value-previous_value);
            if(check<0.00001){ //ending loop if 0.00001 accurate
               i=1000; 
            }else if(i==999 && check>0.00001){
               throw new IllegalStateException("Cannot be determined"); //throwing exception if root can't be found after 1000 iteration
            }
         }   
      }

     return current_value; //returning root
   }
} //End of class