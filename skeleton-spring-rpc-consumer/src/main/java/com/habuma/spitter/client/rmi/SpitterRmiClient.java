package com.habuma.spitter.client.rmi;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.habuma.spitter.remote.dto.SpitterDTO;
import com.habuma.spitter.remote.dto.SpittleDTO;
import com.habuma.spitter.remote.service.ISpitterRemoteService;

public class SpitterRmiClient {
  @Autowired
  ISpitterRemoteService spitterService;
	  
  public List<SpittleDTO> getSpittles(String userName) {
	  
    SpitterDTO spitter = spitterService.getSpitter(userName);
    
    return spitterService.getSpittlesForSpitter(spitter);
    
  }



}
