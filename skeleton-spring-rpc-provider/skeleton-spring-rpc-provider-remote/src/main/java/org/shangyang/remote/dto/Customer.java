package org.shangyang.remote.dto;

import java.io.Serializable;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1783960325853963788L;
	
	String name;

	public Customer(){
		
	}
	
	public Customer(String name){
		
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
