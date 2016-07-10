package com.habuma.spitter.remote.dto;

import java.io.Serializable;
import java.util.Date;

public class SpittleDTO implements Serializable{

  private static final long serialVersionUID = -1508835362555787685L;
	
  private Long id;
  private SpitterDTO spitter;
  private String text;
  private Date when;

  static long MAX_SPITTLE_ID;
  
  public SpittleDTO( SpitterDTO spitterDto, String text, Date when ){
	  
	  this.spitter = spitterDto;
	  
	  this.text = text;
	  
	  this.when = when;
	  
  }
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getText() {
    return this.text;
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
  public Date getWhen() {
    return this.when;
  }

  public void setWhen(Date when) {
    this.when = when;
  }

  public SpitterDTO getSpitterDTO() {
    return this.spitter;
  }

  public void setSpitter(SpitterDTO spitter) {
    this.spitter = spitter;
  }
}
