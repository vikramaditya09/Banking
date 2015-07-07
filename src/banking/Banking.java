/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author vikramaditya.tanwar
 */
public class Banking {

    Scanner in=new Scanner(System.in); 
    public static void main(String[] args) {
       Banking ban=new Banking();
       bank b1=new bank();
       
        String s="y";
        System.out.println("****************************************\n"
                + "************Welcome To My Bank**********\n"
                + "****************************************");  
          ban.MainMenu(b1);
    }
    void MainMenu(bank b){
       
       int choice=0;       
       String c="y";  
       
       while(true)
            try{
                    
                    System.out.println("\nMain Menu\n1.Account Management\n2.Transaction Management\n3.Exit");
                    choice=in.nextInt();
                    
                    
                    switch(choice){
                        case 1:accountmanagement(b);break;
                        case 2:transactionmanagement(b);break;
                        case 3:return;
                        default:System.out.println("bad choice");
                    }
                    
                  
                }
            catch(Exception e){
                e.printStackTrace();
            }
           
       
    
    }
    public void accountmanagement(bank b1){
        in=new Scanner(System.in);
        System.out.println("\n*****Main Menu for Account Management*****\n\n"
                + "1.Open New Account\n"
                + "2.Display All Accounts\n"
                + "3.Sort by Account Number\n"
                + "4.Sort by Account Type\n"
                + "5.Sort by date of Creation of account\n"
                + "6.Sort by Customer Name\n"
                + "7.Search Account by Customer Name\n"
                + "8.Search Account by Balance\n");        
        try{
            int choice=in.nextInt();
            switch(choice){
                case 1:b1.openAccount();break;
                case 2:b1.displayAccounts();break;
                case 3:b1.sortbyAccount();break;
                case 4:b1.sortAccountByType();break;
                case 5:b1.sortAccountByDate();break;
                case 6:b1.sortAccountByCustomer();break;
                case 7:b1.searchAccountByCustomerName();break;
                case 8:b1.searchAccountByBalance();break;
                default:System.out.println("Bad Choice");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    public void transactionmanagement(bank b1){
        in=new Scanner(System.in);
        System.out.println("\n*****Main Menu for Transaction Management*****\n\n"
                + "1.Add transaction\n"
                + "2.Delete Transaction\n"
                + "3.Edit Transaction\n"
                + "4.Get Transaction of a Account By Date\n"
                + "5.Sort Transaction by Amount\n"
                + "6.Sort Transaction by Date\n"
                + "7.Sort Transaction by Type\n");
       
        try{
            int choice=in.nextInt();
            switch(choice){
                case 1:b1.addTransaction();break;
                case 2:b1.deleteTransaction();break;
                case 3:b1.editTransaction();break;
                case 4:b1.transactionBetween();break;
                case 5:b1.sortTranactionByAmount();break;
                case 6:b1.sortTransactionByDate();break;
                case 7:b1.sortTransactionByType();break;
                default:System.out.println("Bad Choice");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        
    }
    
}
