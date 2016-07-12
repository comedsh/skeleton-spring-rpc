package com.habuma.spitter.remote.dto;

import java.io.Serializable;

public class SpitterDTO implements Serializable{

  private static final long serialVersionUID = -458777943945067058L;
	
  private String username;
  
  private String password;
  
  private String fullName;
  
  private String email;  
  
  public SpitterDTO(){
	  
  }  
  
  public SpitterDTO(String username, String fullName, String email ){
	  
	  this.username = username;
	  
	  this.fullName = fullName;
	  
	  this.email = email;
	  
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getFullName() {
    return fullName;
  }
  
  public void setEmail(String email) {
      this.email = email;
  }
  
  public String getEmail() {
      return email;
  }
  
}
