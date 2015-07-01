/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;
import java.util.Scanner;
/**
 *
 * @author vikramaditya.tanwar
 */
public abstract class Accounts {
    int balance;
    int type;
    int deposit;
    int withdraw;
       
    abstract void setbalance(int x);
    abstract int getbalance();
    abstract void deposit();
    abstract void withdraw();    

   
}

class Checkin extends Accounts {
    Scanner in = new Scanner(System.in); 
    Checkin()
    {
        getbalance();
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
}
class Savings extends Accounts {
    Scanner in = new Scanner(System.in); 
    private int bal;
    Savings(){
         
    getbalance();
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

 
    
}

class Business extends Accounts {
    Scanner in = new Scanner(System.in); 
    private int bal;
    Business(){
       getbalance(); 
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
    
    
}
