/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vikramaditya.tanwar
 */
public class Customer implements Comparable<Customer>{
    int CustomerId;
    String CustomerName;
    String Address;
    int AccountId;
    List<Integer> TransactionId;
    
    Customer(){
        
        TransactionId=new LinkedList<>();
    
    }
    Customer(String name,int id,String address,int accountId){
        TransactionId=new LinkedList<>();
        CustomerName=name;
        Address=address;
        CustomerId=id;
        AccountId=accountId;    
    }
    void addAccount(int AccountNumber){
        AccountId=AccountNumber;
        
    }
    void addTransaction(int Transaction){
        TransactionId.add(Transaction);
    
    }

    public int getAccountId() {
        return AccountId;
    }
    public static Comparator<Customer> CustomerComparatorByName = new Comparator<Customer>() {   

        
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.CustomerName.compareTo(o2.CustomerName);
        }
    };
    @Override
    public int compareTo(Customer o) {
        return this.CustomerId-o.CustomerId; //To change body of generated methods, choose Tools | Templates.
    }
   
}