/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankmachine;

import java.io.IOException;
import javax.swing.JOptionPane;



/**
 *
 * @author Peter
 */
public class ATM {
    
    public ATM(){
        
    }
    public int ATM(int banks, int days){
        //Variables
        int issue = 0;
        int toDo = 0;
        String name = "";
        
        try{
            //Ensuring the bank entered can be entered
            if(banks == 1){
                name = "BMO";
            }
            else if(banks == 2){
                name = "RBC";
            }
            else if(banks == 3){
                name = "TD";
            }
            else if(banks == 4){
                name = "Other";
            }
            else{
                issue = 1;
                throw new IOException();
            }
            //Ensuring the number of days for investment is within the peramiters
            if(days < 0 || days > 1825){
                issue = 3;
                throw new IOException();
            }
            //Getting user input on what they would like to do with ATM
            toDo = Integer.parseInt(JOptionPane.showInputDialog("Welcome to " + name + "\n\n" 
                + "Enter the number of what you would like to do: \n\n" + "1. Check current balance\n" 
                + "2. Withdraw \n" + "3. Deposite\n" +"4. Exit"));
            //Checking if the value entered is vaild
            if(toDo < 1 || toDo > 4){
                issue = 2;
                throw new IOException();
            }
            
        }
        
        //Catching errors with input
        catch (IOException e) {
           if(issue == 1){
               System.err.println("Bank option not registered");
               System.err.println("Shutting down");
           }
           else if(issue == 2){
               System.err.println("Option does not register");
               System.err.println("Shutting down");
           }
           else if(issue == 3){
               System.err.println("Cannot register number of days");
               System.err.println("Shutting down");
           }
           else{
               System.err.println("Unexpected input");
               System.err.println("Shutting down");
           }
           System.exit(0);
    	}
        
        return toDo;
    }
    
    
    public double Value(Double initial,double interest,int days ){
        //Variables
        double value = 0;
        int issue = 0;
        
        
        try{
            //Ensuring the user isnt in overdraft
            if(initial < 0){
                issue = 1;
                value = initial;
                throw new IOException();
            }
            //Running the math for how much the user has
            else{
                value = initial*(Math.pow((1 + interest),(days/365)));
               
            }
        }
        
        //Catching errors with input
        catch (IOException e) {
           if(issue == 1){
               System.err.println("Cannot make interest while in overdraft");
               System.err.println("Shutting down");
           }
           else{
               System.err.println("Unexpected input");
               System.err.println("Shutting down");
               System.exit(0);
           }
           
    	}
        return value;
    }
    
    public double Withdraw(double money){
        //Varaibles
        int issue = 0;
        
        
        try{
            double remove = Double.parseDouble(JOptionPane.showInputDialog("How much would you like to remove \n" +
               "(Positive value please)"));
            //Ensuring value removed is positive
            if(remove < 0){
                issue = 1;
                throw new IOException();
                
            }
            //Adding balance
            else{
                money -= remove;
                System.out.println("You now have: $" + money);
            }
        }
        //Catching errors for user entered information
        catch (IOException e) {
           if(issue == 1){
               System.err.println("Cannot withdraw negative value");
           }
           else{
               System.err.println("Unexpected input");
               System.err.println("Shutting down");
               System.exit(0);
           }
           
    	}
        return money;
    }
    public double Deposit(double money){
        //Varaibles
        int issue = 0;
        double add = Double.parseDouble(JOptionPane.showInputDialog("How much would you like to add"));
        
        try{
            //Ensuring value added is positive
            if(add < 0){
                issue = 1;
                throw new IOException();
                
            }
            //Adding balance
            else{
                money += add;
                System.out.println("You now have: $" + money);
            }
        }
        //Catching errors for user entered information
        catch (IOException e) {
           if(issue == 1){
               System.err.println("Cannot input negative value");
           }
           else{
               System.err.println("Unexpected input");
               System.err.println("Shutting down");
               System.exit(0);
           }
           
    	}
        return money;
    }
   
}
