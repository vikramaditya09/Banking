/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author vikramaditya.tanwar
 */
public class Customer {
    String name;
    String address;
    int AccountId;
    int CustomerId;
    
    Customer(){
    
    }
    Customer(String n,String a,int z,int y){
    
     name=n;
     address=a;
     AccountId=z;
     CustomerId=y;
}
}