package org.shangyang.remote.dto;

import java.io.Serializable;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8974282536452861430L;
	
    private String name;
    
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
	
}
