/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Date;
/**
 *
 * @author vikramaditya.tanwar
 */
public abstract class Accounts implements Comparable<Accounts> {
    int balance=1000;
    int type;
    int customerId;
    int AccountID;  
    public Date CreationDate;
    abstract void setbalance(int x);
    abstract int getbalance();
    abstract void deposit();
    abstract void withdraw();    
    abstract void dispaly();
    public static Comparator<Accounts> AccountComparator = new Comparator<Accounts>() {   

        @Override
        public int compare(Accounts o1, Accounts o2) {
            return o1.AccountID-o2.AccountID;            
        } 
    };
    public static Comparator<Accounts> BalanceComparator = new Comparator<Accounts>() {   

        @Override
        public int compare(Accounts o1, Accounts o2) {
            return o1.balance-o2.balance;            
        } 
    };
    public static Comparator<Accounts> TypeComparator = new Comparator<Accounts>() {   

        @Override
        public int compare(Accounts o1, Accounts o2) {
            return o1.type-o2.type;            
        } 
    };
    public static Comparator<Accounts> DateComparator = new Comparator<Accounts>() {   

        @Override
        public int compare(Accounts o1, Accounts o2) {
            return o1.CreationDate.compareTo(o2.CreationDate);            
        } 
    };
    

   
}

class Checkin extends Accounts {
    Scanner in = new Scanner(System.in); 
    Checkin(int CustomerID,int acc)
    {
        customerId=CustomerID;
        this.AccountID=acc;
        type=1;
        CreationDate=new Date();
    }
    @Override
    public int getbalance() {
        return balance;
    }

    @Override
    void setbalance(int bal) {
      this.balance = bal;
    
    }
     @Override
     void deposit()
     {   
         int b=this.getbalance();
         setbalance(in.nextInt()+this.getbalance());
         System.out.println("successfully deposited");
         
     }
     @Override
     void withdraw()
     {   int c=this.getbalance();
         setbalance(c-in.nextInt());
     }
    @Override
     void dispaly(){
         System.out.println("*****ACCOUNT DETAIL******");
         System.out.println("Account Number: "+AccountID);
         System.out.println("Type of Account is: Check In ");
         System.out.println("Available Balance is: "+balance);
         System.out.println("Customer ID: "+customerId);   
         System.out.println("*************************\n");
         
     }

    @Override
    public int compareTo(Accounts o) {
        return this.AccountID-o.AccountID; 
    }
}
class Savings extends Accounts {
    Scanner in = new Scanner(System.in); 
    private int bal;
    Savings(int CustomerID,int acc)
    {
        customerId=CustomerID;
        this.AccountID=acc;
        type=2;
        CreationDate=new Date();
    }

    @Override
    public int getbalance() {
      return balance;  
    }

    @Override
    void setbalance(int bal) {
       this.bal = bal; 
    }
      @Override
     void deposit()
     {   
         int b=this.getbalance();
         setbalance(in.nextInt()+this.getbalance());
         
     }
     @Override
     void withdraw()
     {   int c=this.getbalance();
         setbalance(c-in.nextInt());
     }
     @Override
     void dispaly(){     
         System.out.println("\n*****ACCOUNT DETAIL******");
         System.out.println("Account Number: "+AccountID);
         System.out.println("Type of Account is: Savings");
         System.out.println("Available Balance is: "+balance);
         System.out.println("Customer ID: "+customerId); 
         System.out.println("*************************\n");
     }
     @Override
    public int compareTo(Accounts o) {
        return this.AccountID-o.AccountID; 
    }
 
    
}

class Business extends Accounts {
    Scanner in = new Scanner(System.in); 
    private int bal;
    Business(int CustomerID,int acc)
    {
        customerId=CustomerID;
        this.AccountID=acc;
        type=3;
        CreationDate=new Date();
    }
            
   @Override
    public void setbalance(int bal) {
        this.bal = bal;
    }
    
    
    @Override
    public int getbalance() {
        return balance;
    }
     @Override
     void deposit()
     {   
         int b=this.getbalance();
         setbalance(in.nextInt()+this.getbalance());
         
     }
     @Override
     void withdraw()
     {   int c=this.getbalance();
         setbalance(c-in.nextInt());
     }
     @Override
     void dispaly(){         
         System.out.println("\n*****ACCOUNT DETAIL******");
         System.out.println("Account Number: "+AccountID);
         System.out.println("Type of Account is: Business");
         System.out.println("Available Balance is: "+balance);
         System.out.println("Customer ID: "+customerId); 
         System.out.println("*************************\n");
     }
     @Override
    public int compareTo(Accounts o) {
        return this.AccountID-o.AccountID; 
    }
    
}
