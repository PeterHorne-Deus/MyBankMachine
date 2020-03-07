/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankmachine;

import javax.swing.*;
/**
 *
 * @author Peter
 */
public class MyBankMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables
        boolean exit = false;
        int option = 0;
        int chooseAgain = 0;
        
        //User input variables
        int banks = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of the bank you use: \n" 
            + "1. BMO\n" + "2. RBC\n" + "3. TD\n" + "4. Other" ));
        double money = Integer.parseInt(JOptionPane.showInputDialog("Please enter your account balace: "));
        double interest = Double.parseDouble(JOptionPane.showInputDialog("Please enter your yearly interest amount: "));
        int days = Integer.parseInt(JOptionPane.showInputDialog("Please enter the numbers of days you would like to invest: \n" 
            + "Up to 5 years (1825 days)"));
        
        //Setting up the ATM class
        ATM a = new ATM();
        
        //Running the ATM based on user input
        do{
            option = a.ATM(banks, days);

            if(option == 1){
                if(chooseAgain == 0){
                    money = a.Value(money,interest,days);
                    System.out.println("You Now Have: $" + money);
                    chooseAgain ++;
                }
                else{
                    System.out.println("You Have: $" + money);
                }
            }
            else if(option == 2){
                money = a.Withdraw(money);
            }
            else if(option == 3){
                money = a.Deposit(money);
            }
            else{
                exit = true;
            }
            
        }while(exit != true);
    }
    
}
