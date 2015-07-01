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
public abstract class Accounts {
    int bal;
    String name;
    String address;
    String city;
    
   abstract void checkin();
   
   abstract void savings();
    
   abstract void business();
  
   abstract void sort();
    
}

class A extends Accounts
{

    @Override
    void checkin() {
       System.out.println("enter the customer name" +name);
       
       System.out.println("enter the customer address" +address);
       
       System.out.println("enter the customer city" +city);
       
       bal=100;
       
       System.out.println("inital deposit amount" +bal);
    }

    @Override
    void savings() {
         System.out.println("enter the customer name" +name);
       
       System.out.println("enter the customer address" +address);
       
       System.out.println("enter the customer city" +city);
       
       bal=100;
       
       System.out.println("inital deposit amount" +bal);
    }

    @Override
    void business() {
         System.out.println("enter the customer name" +name);
       
       System.out.println("enter the customer address" +address);
       
       System.out.println("enter the customer city" +city);
       
       bal=100;
       
       System.out.println("inital deposit amount" +bal);
    }

    @Override
    void sort() {
       
    }
}