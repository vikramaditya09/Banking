/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;
import java.util.*;
import banking.exceptions.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author vikramaditya.tanwar
 */
public class bank {
    int LastAccNo=10;
    int LastCustNo=10;
    int LastTransNo=10;    
    HashMap<Integer,Accounts> accounts;
    HashMap<Integer,Customer> customers ;
    HashMap<Integer,Transaction> transactions;
    bank()
    {
        accounts=new HashMap<>();
        customers=new HashMap<>();
        transactions=new HashMap<>();
    }
    //Code For Account management
    void openAccount() throws CustomerIdInvalid{
        Accounts ac=null;
        Customer c=null;
        try{
            Scanner in=new Scanner(System.in);
            System.out.println("Choose Type of Account\n1.CheckIn\n2.Savings\n3.Business");
            int choice=in.nextInt();
            System.out.println("Enter Customer Name:");
            String name=in.next();
            System.out.println("Enter Customer Address:");
            String addr=in.next();
            LastCustNo++;
            LastAccNo++;
            switch(choice){
                case 1: ac=new Checkin(LastCustNo,LastAccNo);
                        accounts.put(LastAccNo, ac);
                        c=new Customer(name,LastCustNo,addr,LastAccNo);
                        customers.put(LastCustNo,c);
                        break;                
                case 2: ac=new Savings(LastCustNo,LastAccNo);
                        accounts.put(LastAccNo, ac);
                        c=new Customer(name,LastCustNo,addr,LastAccNo);
                        customers.put(LastCustNo,c);
                        break;
                case 3: ac=new Business(LastCustNo,LastAccNo);
                        accounts.put(LastAccNo, ac);
                        c=new Customer(name,LastCustNo,addr,LastAccNo);
                        customers.put(LastCustNo,c);
                        break;
                default:System.out.println("Worng Input");break;
            }
            System.out.println("Thank You! "+name+"\nYour Customer ID is:"+LastCustNo+"\nAnd your Account Number is:"+LastAccNo+"\n\n");
        }
        catch(Exception e)
        {
            System.out.println("Unable to open Account");
        }
    }
    void displayAccounts(){   
        //System.out.println("\nAccount List <account numbers>");
        accounts.values().stream().forEach((acc) -> {
            acc.dispaly();
            //System.out.println("Account number: "+acc.AccountID);
        });
       
    }
    void sortbyAccount(){
       List<Accounts> ac=new ArrayList<Accounts>(accounts.values());       
       ac.sort(Accounts.AccountComparator);
       for(Accounts a:ac)
       {
           a.dispaly();
       }
    }
    void sortAccountByType(){
       List<Accounts> ac=new ArrayList<Accounts>(accounts.values());       
       ac.sort(Accounts.TypeComparator);
       ac.stream().forEach((a) -> {
           a.dispaly();
        });
    }
    void sortAccountByDate(){
       List<Accounts> ac=new ArrayList<Accounts>(accounts.values());       
       ac.sort(Accounts.DateComparator);
       ac.stream().forEach((a) -> {
           a.dispaly();
        });
    }
    void sortAccountByCustomer(){
       List<Customer> cl=new ArrayList<Customer>(customers.values());
       cl.sort(Customer.CustomerComparatorByName);
       for(Customer c:cl){
           System.out.println("Customer Name: "+c.CustomerName);
           Accounts a=accounts.get(c.AccountId);
           a.dispaly();
       }
       
    }
    void searchAccountByCustomerName(){
        Scanner in=new Scanner(System.in);
        boolean search=false;
        System.out.println("Enter Name Of the Customer:");
        String s=in.next();
        for(Customer c:customers.values()){
            if(s.equals(c.CustomerName)){
               search=true;
               accounts.get(c.AccountId).dispaly();               
            }
        }
        if(!search){
           System.out.println("Customer Not Found"); 
        }
        
    }
    void searchAccountByBalance(){
        System.out.println("\nEnter your Choice\n1.Exact Balance\n2.More than Balance\n3.Less than Balance\n4.Balance Range");
        Scanner in=new Scanner(System.in);
        int amount;
        int choice=in.nextInt();
        boolean flag=true;
        switch(choice){
            case 1: System.out.println("Enter the Amount to be search");
                    amount=in.nextInt();
                    for(Accounts a:accounts.values()){
                            if(a.balance==amount){
                                a.dispaly();
                                flag=false;
                            }   
                    }
                    if(flag)
                        System.out.println("No Data Found");
                    break;
            case 2: System.out.println("Enter the Amount to be search for equal and more");
                    amount=in.nextInt();
                    for(Accounts a:accounts.values()){
                            if(a.balance>=amount){
                                a.dispaly();
                                flag=false;
                            }
                    }
                    if(flag)
                        System.out.println("No Data Found");
                    break;
            case 3: System.out.println("Enter the Amount to be search for equal and less");
                    amount=in.nextInt();
                    for(Accounts a:accounts.values()){
                            if(a.balance<=amount){
                                a.dispaly();
                                flag=false;
                            }
                    }
                    if(flag)
                        System.out.println("No Data Found");
                    break;
            case 4: System.out.println("Enter the Amount range\nMinimum:");
                    amount=in.nextInt();
                    System.out.println("Maximum:");
                    int max=in.nextInt();
                    for(Accounts a:accounts.values()){
                            if(a.balance>=amount&&a.balance<=max){
                                a.dispaly();
                                flag=false;
                            }
                    }
                    if(flag)
                        System.out.println("No Data Found");
                    break;
            default:System.out.println("Worn Input");
        }
        
    }
    //Now onwards code for Transaction management
    void addTransaction()throws CustomerIdInvalid,BalanceNotSufficient{
        try{
            LastTransNo++;
            Scanner in=new Scanner(System.in);
            System.out.println("Choose Type of Transaction\n1.Credit\n2.Debit");
            int choice=in.nextInt();
            if(choice==1){
                System.out.println("Enter Customer ID: ");
                int Cid=in.nextInt();
                Customer c=customers.get(Cid);
                if(c==null) 
                    throw new CustomerIdInvalid("Customer Not valid");
                System.out.println("Enter the Amount to be credit");
                int amount=in.nextInt();
                Accounts a=accounts.get(c.AccountId);
                a.balance=a.balance+amount;
                Transaction t=new CreditTransaction(LastTransNo,Cid,c.AccountId,amount);
                c.TransactionId.add(LastTransNo);
                transactions.put(LastTransNo, t);
                t.displayTransaction();
            }
            if(choice==2){
                System.out.println("Enter Customer Number");
                int Cid=in.nextInt();
                Customer c=customers.get(Cid);
                if(c==null) 
                    throw new CustomerIdInvalid("Customer Not valid");
                System.out.println("Enter the Amount to be Debit");
                int amount=in.nextInt();
                Accounts a=accounts.get(c.AccountId);
                if(a.balance>=amount)
                    a.balance=a.balance-amount;
                else
                    throw new BalanceNotSufficient("Balance is less");
                Transaction t=new DebitTransaction(LastTransNo,Cid,c.AccountId,amount);
                c.TransactionId.add(LastTransNo);
                transactions.put(LastTransNo, t);
                t.displayTransaction();
            }          
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
    
    }
    void transactionBetween(){
        Scanner in=new Scanner(System.in);
        Date after;
        Date before;
        String expectedPattern = "MM/dd/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
        try
        { // (2) give the formatter a String that matches the SimpleDateFormat pattern
          System.out.println("Enter Account Number");
          int acc=in.nextInt();
          boolean search=false;
          Customer cust=null;
          for(Customer c:customers.values()){
            if(c.AccountId==acc){
               search=true;
               cust=c;               
            }
          }
          if(!search){
           System.out.println("Account Not Found"); 
           return;
          }
          System.out.println("Enter Starting Date in MM/dd/yyyy format");
          String userInput = in.next();
          after = formatter.parse(userInput);
          System.out.println("Enter Starting Date in MM/dd/yyyy format");
          userInput = in.next();
          before = formatter.parse(userInput);
          for(int t:cust.TransactionId){
              Transaction trans=transactions.get(t);
              if(trans.getDt().after(before)&&trans.getDt().before(after))
                  trans.displayTransaction();                  
          }
          
        }
        catch (Exception e)
        {
          System.out.println(e.toString());
        }
    }
    void sortTranactionByAmount(){
       List<Transaction> tr=new ArrayList<Transaction>(transactions.values());       
       tr.sort(Transaction.AmountComparator);
       for(Transaction t:tr)
       {
           t.displayTransaction();
       }
        
    }
    void sortTransactionByType(){
       List<Transaction> tr=new ArrayList<Transaction>(transactions.values());       
       tr.sort(Transaction.TypeComparator);
       for(Transaction t:tr)
       {
           t.displayTransaction();
       }
    }
    void sortTransactionByDate(){
       List<Transaction> tr=new ArrayList<Transaction>(transactions.values());       
       tr.sort(Transaction.DateComparator);
       for(Transaction t:tr)
       {
           t.displayTransaction();
       }
    }
    void deleteTransaction(){
        System.out.println("Enter the transaction Id to be delete");
        Scanner in=new Scanner(System.in);
        int tid=in.nextInt();
        for(Customer c:customers.values()){
            for(int t:c.TransactionId){
                if(t==tid){
                    c.TransactionId.remove(t);
                    transactions.remove(t);
                }           
            }
        }
        
    }
    void editTransaction(){
        System.out.println("Enter the transaction Id to be Edit");
        Scanner in=new Scanner(System.in);
        int tid=in.nextInt();
        for(Transaction t:transactions.values()){
            if(tid==t.getTransactionId()){
                t.editTransaction();
            }
        }
    }
    
    
   
}