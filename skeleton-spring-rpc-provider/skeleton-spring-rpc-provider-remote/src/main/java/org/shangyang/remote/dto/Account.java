package org.shangyang.remote.dto;

import java.io.Serializable;

public class Account implements Serializable{

	private static final long serialVersionUID = -8974282536452861430L;
	
    String name;
    
    Customer customer;
    
    public Account(){
    	
    }
    
    public Account(String name){
    	this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
