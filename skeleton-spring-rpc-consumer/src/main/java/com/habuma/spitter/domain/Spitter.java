package com.habuma.spitter.domain;

import java.io.Serializable;

public class Spitter implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = -458777943945067058L;
	
	
  private Long id;
  private String username;
  private String password;
  private String fullName;
  private String email;  
  private boolean updateByEmail;

  static long MAX_SPITTER_ID = 0;
  
  public Spitter(){
	  
  }
  
  public Spitter(String username, String fullName, String email ){
	  
	  this.id = ++ MAX_SPITTER_ID;
	  
	  this.username = username;
	  
	  this.fullName = fullName;
	  
	  this.email = email;
	  
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public void setUpdateByEmail(boolean updateByEmail) {
      this.updateByEmail = updateByEmail;
  }
  
  public boolean isUpdateByEmail() {
    return updateByEmail;
  }
  
  
  @Override
  public boolean equals(Object obj) {
    Spitter other = (Spitter) obj;
    return other.fullName.equals(fullName) && other.username.equals(username) && other.password.equals(password);
  }
  
  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
  }
}
