package com.habuma.spitter.remote.dto;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class SpitterDTO implements Serializable{

  private static final long serialVersionUID = -458777943945067058L;
	
  private Long id;
  private String username;
  private String password;
  private String fullName;
  private String email;  
  private boolean updateByEmail;
  
  public SpitterDTO(String username, String fullName, String email ){
	  
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
    SpitterDTO other = (SpitterDTO) obj;
    return other.getFullName().equals(this.fullName) && StringUtils.equals(other.getUsername(), this.username) && StringUtils.equals(other.getPassword(), this.password);
  }
  
  @Override
  public int hashCode() {
    return super.hashCode();
  }
  
}
