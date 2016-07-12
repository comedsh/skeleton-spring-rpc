package com.habuma.spitter.remote.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habuma.spitter.remote.dto.SpitterDTO;
import com.habuma.spitter.remote.dto.SpittleDTO;

@WebService(serviceName="SpitterWebService")
@Service
public class SpitterWebServiceEndpoint{

	@Autowired
	ISpitterRemoteService spitterWebService;
	
	@WebMethod
	public List<SpittleDTO> getSpittlesForSpitter(SpitterDTO spitterDto) {
		
		return spitterWebService.getSpittlesForSpitter(spitterDto);
	}

	@WebMethod
	public List<SpittleDTO> getSpittlesForSpitter(String username) {

		return spitterWebService.getSpittlesForSpitter(username);
	}

	@WebMethod
	public SpitterDTO getSpitter(String username) {

		return spitterWebService.getSpitter(username);
	}

	@WebMethod
	public void saveSpitter(SpitterDTO spitterDto) {
		
		spitterWebService.saveSpitter(spitterDto);
		
	}

	@WebMethod
	public void saveSpittle(SpittleDTO spittleDto) {
		
		spitterWebService.saveSpittle(spittleDto);
		
	}

	@WebMethod
	public void clear() {
		
		spitterWebService.clear();
		
	}	
	
}
