/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.exceptions;

/**
 *
 * @author tarinder.singh
 */
public class CustomerIdInvalid extends Exception {

    /**
     *
     * @param s is the message to the exception
     */
    public CustomerIdInvalid(String s){
        super(s);       
    }
    CustomerIdInvalid(){
        super();       
    }   
}

