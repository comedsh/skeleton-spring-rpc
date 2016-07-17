package com.habuma.spitter.remote.service;

import com.habuma.spitter.remote.dto.SpitterDTO;

public interface AlertService {
	
  public void sendSpittleAlert(SpitterDTO spitterDto);

}
