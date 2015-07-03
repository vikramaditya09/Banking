/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vikramaditya.tanwar
 */
public class Customer {
    int CustomerId;
    String CustomerName;
    String Address;
    List<Integer> AccountId;
    List<Integer> TransactionId;
    
    Customer(){
        AccountId=new LinkedList<>();
        TransactionId=new LinkedList<>();
    
    }
    Customer(String name,int id,String address,int accountId){
        AccountId=new LinkedList<>();
        TransactionId=new LinkedList<>();
        CustomerName=name;
        Address=address;
        CustomerId=id;
        AccountId.add(accountId);    
    }
    void addAccount(int AccountNumber){
        AccountId.add(AccountNumber);
        
    }
    void addTransaction(int Transaction){
        TransactionId.add(Transaction);
    
    }

    public List<Integer> getAccountId() {
        return AccountId;
    }
   
}