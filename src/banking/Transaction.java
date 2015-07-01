/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author tarinder.singh
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
abstract class Transaction {
    private int TransactionId;
    private Date Dt;
    private int CustomerId;
    private int AccountId;
    private int type;
    private int TransactionAmount;
    void editTransaction(){
        try{        
            Scanner in=new Scanner(System.in);
            int id=0;
            System.out.println("Press '0' if Do not want to change");
            System.out.println("Change Transaction ID");
            id=in.nextInt();
            if(id!=0)
                setTransactionId(id);
            System.out.println("Change Transaction Amount");
            id=in.nextInt();
            if(id!=0)
                setTransactionAmount(id);
            System.out.println("Change Customer ID");
            id=in.nextInt();
            if(id!=0)
                setCustomerId(id);
            System.out.println("Change Account ID");
            id=in.nextInt();
            if(id!=0)
                setAccountId(id);
            
            System.out.println("Change Transaction type \n>>>>>>>: 1->Debit    2->Credit :<<<<<<");
            id=in.nextInt();
            if(id!=0)
                setType(id);
            System.out.println("Press '1' to Change Date then enter date in dd-mm-yyyy Format");
            id=in.nextInt();
            if(id!=0){
                Date newdate=null;
                SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy"); 
                String input =in.next();
                try
                {
                newdate = ft.parse(input); 
                setDt(newdate);
                }
                catch (ParseException e) { 
                    System.out.println("Unparseable using " + ft);            
                }

            }
            System.out.println("Editing Trasaction Completed");    
        }
        catch (Exception e) { 
            System.out.println("Error While Editing Trasaction");            
        }
    }
    abstract public void setTransaction(int TransactionId,int CustomerId,int AccountId,int TransactionAmount);
    abstract public void displayTransaction();
            

    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

    public void setDt(Date Dt) {
        this.Dt = Dt;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public void setTransactionAmount(int TransactionAmount) {
        this.TransactionAmount = TransactionAmount;
    }

    public void setTransactionId(int TransactionId) {
        this.TransactionId = TransactionId;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAccountId() {
        return AccountId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public Date getDt() {
        return Dt;
    }

    public int getTransactionAmount() {
        return TransactionAmount;
    }

    public int getTransactionId() {
        return TransactionId;
    }

    public int getType() {
        return type;
    }
    
}
class CreditTransaction extends Transaction{
    
    CreditTransaction(){
        super.setType(1);
        
    }       
    @Override
    public void setTransaction(int TransactionId,int CustomerId,int AccountId,int TransactionAmount){
        super.setAccountId(AccountId);
        super.setCustomerId(CustomerId);
        super.setTransactionId(TransactionId);
        super.setTransactionAmount(TransactionAmount);
        super.setDt(new Date());        
    }
    @Override
    public void displayTransaction(){
        System.out.println("Transaction ID:"+this.getTransactionId());
        System.out.println("Transaction Amount"+this.getTransactionAmount()+" Credited");
        System.out.println("Customer ID:"+this.getCustomerId());
        System.out.println("In Account Number:"+this.getAccountId());
        System.out.println("On Date:"+this.getDt().toString());
    }
    
}
class DebitTransaction extends Transaction{
    
    DebitTransaction(){
        super.setType(2);
        
    }       
    @Override
    public void setTransaction(int TransactionId,int CustomerId,int AccountId,int TransactionAmount){
        super.setAccountId(AccountId);
        super.setCustomerId(CustomerId);
        super.setTransactionId(TransactionId);
        super.setTransactionAmount(TransactionAmount);
        super.setDt(new Date());        
    }
    @Override
    public void displayTransaction(){
        System.out.println("Transaction ID:"+this.getTransactionId());
        System.out.println("Transaction Amount"+this.getTransactionAmount()+" Credited");
        System.out.println("Customer ID:"+this.getCustomerId());
        System.out.println("In Account Number:"+this.getAccountId());
        System.out.println("On Date:"+this.getDt().toString());
    }
    
}
