package com.habuma.spitter.remote.service;

import java.util.List;

import javax.jws.WebService;

import com.habuma.spitter.remote.dto.SpitterDTO;
import com.habuma.spitter.remote.dto.SpittleDTO;

/**
 * 
 * Export the interface, which invoked by the 3rd components.
 * 
 * @author 商洋
 *
 */
@WebService
public interface ISpitterRemoteService {
	
	public List<SpittleDTO> getSpittlesForSpitter(SpitterDTO spitterDto);
	
	public List<SpittleDTO> getSpittlesForSpitter(String username);
	
	public SpitterDTO getSpitter(String username);
	
	public void saveSpitter(SpitterDTO spitterDto);
	
	public void saveSpittle(SpittleDTO spittleDto);
	
	public void clear();
	
}
